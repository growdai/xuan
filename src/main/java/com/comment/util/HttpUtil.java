package com.comment.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String getService(String path) {
        final HttpClient httpClient = new HttpClient();
        // 链接超时
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(120000);
        // 读取超时
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(120000);
        final GetMethod method = new GetMethod(path);
        method.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("Content-type", "application/json; charset=UTF-8");
        String response = "";
        try {
            int status = httpClient.executeMethod(method);
            if (status >= 300 || status < 200) {
                logger.error("callservice error", method.getResponseBodyAsString());
            }
            response = parserResponse(method);
        } catch (IOException e) {
            logger.error("callservice error", e);
        } finally {
            method.releaseConnection();
        }
        return response;
    }

	public static String postService(String requestJson, String path) {
		final HttpClient httpClient = new HttpClient();
		// 链接超时
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(300000);
		// 读取超时
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(300000);
		final PostMethod method = new PostMethod(path);
		String contentType = "application/json; charset=UTF-8";
		String charset = "UTF-8";
		method.setRequestHeader("Content-type", contentType);
        String response = "";
		try {
			method.setRequestEntity(new StringRequestEntity(requestJson, contentType, charset));
			int status = httpClient.executeMethod(method);
			if (status >= 300 || status < 200) {
				logger.error("callservice error", method.getResponseBodyAsString());
			}
            response = parserResponse(method);
		} catch (IOException e) {
            logger.error("callservice error", e);
		} finally {
			method.releaseConnection();
		}

        return response;
	}

    /**
     * NameValuePair[] param = {
     * new NameValuePair("method","search"),
     * new NameValuePair("isall","0") } ;
     * @param param
     * @param path
     * @return
     */
    public static String postService(NameValuePair[] param, String path) {
        final HttpClient httpClient = new HttpClient();
        // 链接超时
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(120000);
        // 读取超时
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(120000);
        final PostMethod method = new PostMethod(path);
        method.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        method.setRequestBody(param);
        String response = "";
        try {
            int status = httpClient.executeMethod(method);
            if (status >= 300 || status < 200) {
            }
            response = HttpUtil.parserResponse(method);
        } catch (IOException e) {
            logger.error("callservice error", e);
        } finally {
            method.releaseConnection();
        }
        return response;
    }


	/**
	 * 解析http请求的response
	 *
	 * @param method
	 * @return 请求结果
	 * @throws IOException
	 */
	public static String parserResponse(HttpMethodBase method) throws IOException {
		StringBuilder contentBuffer = new StringBuilder();
		InputStream in = method.getResponseBodyAsStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, method.getResponseCharSet()));
		String inputLine = null;
		while ((inputLine = reader.readLine()) != null) {
			contentBuffer.append(inputLine);
		}
		in.close();
		return contentBuffer.toString();
	}


	/***
	 * 上传本地文件
	 * @param uploadPath
	 * @param fileFieldName
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String uploadLocalFile(String uploadPath, String fileFieldName, String srcFile, Map<String, String> params) throws Exception{
		File file = new File(srcFile);
		PostMethod filePost = new PostMethod(uploadPath);
		HttpClient client = new HttpClient();
		String response = null;
		try {
			// 通过以下方法可以模拟页面参数提交
			if(params != null && !params.isEmpty()){
				for(String paramKey : params.keySet()){
					filePost.setParameter(paramKey, params.get(paramKey));
				}
			}
			Part[] parts = { new FilePart(fileFieldName, file) };
			filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
			client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
				response = HttpUtil.parserResponse(filePost);
			} else {
				throw new Exception(filePost.getResponseBodyAsString());
			}

		} catch (Exception ex) {
			throw ex;
		} finally {
			filePost.releaseConnection();
		}
		return response;
	}

	/***
	 * 上传网络文件
	 * @param uploadPath
	 * @param fileFieldName
	 * @param netFilePath
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String uploadNetFile(String uploadPath, String fileFieldName, String netFilePath, Map<String, String> params) throws Exception{
		URL url = new URL(netFilePath);
		String fileName = StringUtils.substring(url.getFile(), StringUtils.lastIndexOf(url.getFile(), "/")+1, url.getFile().length());
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		InputStream inputStream = connection.getInputStream();
		String contentType = connection.getContentType();
		return uploadFileInputStream(uploadPath, fileFieldName, fileName, contentType, inputStream, params);
	}

	/***
	 * 上传文件流
	 * @param uploadPath
	 * @param fileFieldName
	 * @param fileName
	 * @param inputStream
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String uploadFileInputStream(String uploadPath, String fileFieldName, String fileName, String contentType, InputStream inputStream, Map<String, String> params) throws Exception{
		return uploadFileByteArray(uploadPath, fileFieldName, fileName, contentType, getBytesFormInputStream(inputStream), params);
	}

	/***
	 * 上传文件字节数组
	 * @param uploadPath
	 * @param fileFieldName
	 * @param fileName
	 * @param data
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String uploadFileByteArray(String uploadPath, String fileFieldName, String fileName, String contentType, byte[] data, Map<String, String> params) throws Exception{
		String response = null;
		HttpURLConnection conn = null;
		String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
		try {
			URL url = new URL(uploadPath);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn
					.setRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
			conn.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + BOUNDARY);

			OutputStream out = new DataOutputStream(conn.getOutputStream());

			if(params != null && !params.isEmpty()){
				StringBuffer strBuf = new StringBuffer();
				for(String key : params.keySet()){
					String value = params.get(key);
					if (value == null) {
						continue;
					}
					strBuf.append("\r\n").append("--").append(BOUNDARY).append(
							"\r\n");
					strBuf.append("Content-Disposition: form-data; name=\""
							+ key + "\"\r\n\r\n");
					strBuf.append(value);
				}
				out.write(strBuf.toString().getBytes());
			}


			if (fileName.endsWith(".png")) {
				contentType = "image/png";
			}
			if (contentType == null || contentType.equals("")) {
				contentType = "application/octet-stream";
			}

			StringBuffer fileDescription = new StringBuffer();
			fileDescription.append("\r\n").append("--").append(BOUNDARY).append(
					"\r\n");
			fileDescription.append("Content-Disposition: form-data; name=\""
					+ fileFieldName + "\"; filename=\"" + fileName
					+ "\"\r\n");
			fileDescription.append("Content-Type:" + contentType + "\r\n\r\n");

			out.write(fileDescription.toString().getBytes());

			out.write(data);

			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			out.write(endData);
			out.flush();
			out.close();

			// 读取返回数据
			StringBuffer responseData = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				responseData.append(line).append("\n");
			}
			response = responseData.toString();
			reader.close();
			reader = null;
		} catch (Exception e) {
			System.out.println("发送POST请求出错。" + uploadPath);
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
		return response;
	}


	public static byte[] getBytesFormInputStream(InputStream inputStream) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while ((len = inputStream.read(b, 0, b.length)) != -1) {
			baos.write(b, 0, len);
		}
		inputStream.close();
		return baos.toByteArray();
	}

	    /**
     * 拼接参数
     * @param url
     * @param paramsMap
     * @return
     */
    public static String splitUrl(String url,Map<String,String> paramsMap){
        if (paramsMap==null||paramsMap.isEmpty()){
            return url;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        for (String key:paramsMap.keySet()){
            stringBuilder.append("&").append(key).append("=").append(paramsMap.get(key));
        }
        if (!StringUtils.contains(url,"?")){
            stringBuilder.setCharAt(stringBuilder.indexOf("&"),'?');
        }
        url = stringBuilder.toString();
        return url;
    }
}
