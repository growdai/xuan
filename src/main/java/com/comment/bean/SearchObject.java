package com.comment.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.model.DtlAddressDto;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SN on 2016/2/19.
 */
public class SearchObject<T> {
    private T search;
    private int sortDirection;
    private String sortExpression;
    private String searchText;
    private int pageIndex;
    private int pageSize = 25;

    public SearchObject() {

    }

    public SearchObject(Class<T> clazz) {
        try {
            this.search = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public SearchObject(T obj) {
        this.search = obj;

    }

    public SearchObject setSearch(T search) {
        if (search != null)
            this.search = search;
        return this;
    }

    public T getSearch() {
        return search;
    }

    /**
     * 获取排序方向
     *
     * @return
     */
    public int getSortDirection() {
        return sortDirection;
    }

    /**
     * 设置排序方向
     *
     * @param dir
     */
    public void setSortDirection(int dir) {
        this.sortDirection = dir;
    }

    /**
     * sets 排序字段
     *
     * @param sortExpression
     */
    public void setSortExpression(String sortExpression) {
        this.sortExpression = sortExpression;
    }

    /**
     * 获取排序字段
     *
     * @return
     */
    public String getSortExpression() {
        return sortExpression;
    }

    /**
     * gets 排序字符串
     *
     * @return "排序字段 desc|asc"
     */
    public String getOrderBy() {
        return String.format(" %s %s ", getSortExpression(), getSortDirectionName());
    }

    /**
     * 获得排序字符串
     * author		朱海强
     * createTime	2018-05-28 09:57:49 440
     * @return "排序字段 desc|asc"
     */
    public String getOrderBy(String defaultSortExpression, Integer direction) {
        if(StringUtils.isBlank(this.getSortExpression())){
            this.setSortExpression(defaultSortExpression);
            this.setSortDirection(direction);
        }
        return getOrderBy();
    }

    /**
     * gets 排序方向  asc | desc
     *
     * @return asc | desc
     */
    public String getSortDirectionName() {

        return SortDirection.getName(getSortDirection());
    }

    /**
     * Gets the search text.
     *
     * @return
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * sets the search text.
     *
     * @param searchText
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * Gets the page index.
     */
    public int getPageIndex() {
        if (this.pageIndex <= 0) {
            return 1;
        }
        return pageIndex;
    }

    /**
     * sets the page index.
     *
     * @param pageIndex
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


    /**
     * Gets the page size.
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * sets the page size.
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the start item index.
     *
     * @return int
     */
    public int getStartIndex() {
        int index = ((this.getPageIndex() - 1) * pageSize);
        if (index < 0) {
            index = 0;
        }
        return index;
    }

    public static void main(String[] args) {
        String dtl_address  ="{\"area\":[{\"id\":1,\"name\":\" 北京市 \",\"areaId\":1},{\"id\":380,\"name\":\" 东城区\",\"parentId\":1,\"areaId\":1},{\"id\":381,\"name\":\" 西城区\",\"parentId\":1,\"areaId\":1},{\"id\":382,\"name\":\" 崇文区\",\"parentId\":1,\"areaId\":1},{\"id\":383,\"name\":\" 宣武区\",\"parentId\":1,\"areaId\":1},{\"id\":384,\"name\":\" 朝阳区\",\"parentId\":1,\"areaId\":1},{\"id\":385,\"name\":\" 丰台区\",\"parentId\":1,\"areaId\":1},{\"id\":386,\"name\":\" 石景山区\",\"parentId\":1,\"areaId\":1},{\"id\":387,\"name\":\" 海淀区\",\"parentId\":1,\"areaId\":1},{\"id\":388,\"name\":\" 门头沟区\",\"parentId\":1,\"areaId\":1},{\"id\":389,\"name\":\" 房山区\",\"parentId\":1,\"areaId\":1},{\"id\":390,\"name\":\" 通州区\",\"parentId\":1,\"areaId\":1},{\"id\":391,\"name\":\" 顺义区\",\"parentId\":1,\"areaId\":1},{\"id\":392,\"name\":\" 昌平区\",\"parentId\":1,\"areaId\":1},{\"id\":393,\"name\":\" 大兴区\",\"parentId\":1,\"areaId\":1},{\"id\":394,\"name\":\" 怀柔区\",\"parentId\":1,\"areaId\":1},{\"id\":395,\"name\":\" 平谷区\",\"parentId\":1,\"areaId\":1},{\"id\":396,\"name\":\" 密云县\",\"parentId\":1,\"areaId\":1},{\"id\":397,\"name\":\" 延庆县\",\"parentId\":1,\"areaId\":1},{\"id\":2,\"name\":\" 天津市 \",\"areaId\":1},{\"id\":398,\"name\":\" 和平区\",\"parentId\":2,\"areaId\":1},{\"id\":399,\"name\":\" 河东区\",\"parentId\":2,\"areaId\":1},{\"id\":400,\"name\":\" 河西区\",\"parentId\":2,\"areaId\":1},{\"id\":401,\"name\":\" 南开区\",\"parentId\":2,\"areaId\":1},{\"id\":402,\"name\":\" 河北区\",\"parentId\":2,\"areaId\":1},{\"id\":403,\"name\":\" 红桥区\",\"parentId\":2,\"areaId\":1},{\"id\":404,\"name\":\" 塘沽区\",\"parentId\":2,\"areaId\":1},{\"id\":405,\"name\":\" 汉沽区\",\"parentId\":2,\"areaId\":1},{\"id\":406,\"name\":\" 大港区\",\"parentId\":2,\"areaId\":1},{\"id\":407,\"name\":\" 东丽区\",\"parentId\":2,\"areaId\":1},{\"id\":408,\"name\":\" 西青区\",\"parentId\":2,\"areaId\":1},{\"id\":409,\"name\":\" 津南区\",\"parentId\":2,\"areaId\":1},{\"id\":410,\"name\":\" 北辰区\",\"parentId\":2,\"areaId\":1},{\"id\":411,\"name\":\" 武清区\",\"parentId\":2,\"areaId\":1},{\"id\":412,\"name\":\" 宝坻区\",\"parentId\":2,\"areaId\":1},{\"id\":413,\"name\":\" 宁河县\",\"parentId\":2,\"areaId\":1},{\"id\":414,\"name\":\" 静海县\",\"parentId\":2,\"areaId\":1},{\"id\":415,\"name\":\" 蓟　县\",\"parentId\":2,\"areaId\":1},{\"id\":3,\"name\":\" 河北省 \",\"areaId\":1},{\"id\":39,\"name\":\" 石家庄市\",\"parentId\":3,\"areaId\":1},{\"id\":40,\"name\":\" 唐山市\",\"parentId\":3,\"areaId\":1},{\"id\":41,\"name\":\" 秦皇岛市\",\"parentId\":3,\"areaId\":1},{\"id\":42,\"name\":\" 邯郸市\",\"parentId\":3,\"areaId\":1},{\"id\":43,\"name\":\" 邢台市\",\"parentId\":3,\"areaId\":1},{\"id\":44,\"name\":\" 保定市\",\"parentId\":3,\"areaId\":1},{\"id\":45,\"name\":\" 张家口市\",\"parentId\":3,\"areaId\":1},{\"id\":46,\"name\":\" 承德市\",\"parentId\":3,\"areaId\":1},{\"id\":47,\"name\":\" 沧州市\",\"parentId\":3,\"areaId\":1},{\"id\":48,\"name\":\" 廊坊市\",\"parentId\":3,\"areaId\":1},{\"id\":49,\"name\":\" 衡水市\",\"parentId\":3,\"areaId\":1},{\"id\":4,\"name\":\" 山西省 \",\"areaId\":1},{\"id\":50,\"name\":\" 太原市\",\"parentId\":4,\"areaId\":1},{\"id\":51,\"name\":\" 大同市\",\"parentId\":4,\"areaId\":1},{\"id\":52,\"name\":\" 阳泉市\",\"parentId\":4,\"areaId\":1},{\"id\":53,\"name\":\" 长治市\",\"parentId\":4,\"areaId\":1},{\"id\":54,\"name\":\" 晋城市\",\"parentId\":4,\"areaId\":1},{\"id\":55,\"name\":\" 朔州市\",\"parentId\":4,\"areaId\":1},{\"id\":56,\"name\":\" 晋中市\",\"parentId\":4,\"areaId\":1},{\"id\":57,\"name\":\" 运城市\",\"parentId\":4,\"areaId\":1},{\"id\":58,\"name\":\" 忻州市\",\"parentId\":4,\"areaId\":1},{\"id\":59,\"name\":\" 临汾市\",\"parentId\":4,\"areaId\":1},{\"id\":60,\"name\":\" 吕梁市\",\"parentId\":4,\"areaId\":1},{\"id\":5,\"name\":\" 内蒙古 \",\"areaId\":1},{\"id\":61,\"name\":\" 呼和浩特市\",\"parentId\":5,\"areaId\":1},{\"id\":62,\"name\":\" 包头市\",\"parentId\":5,\"areaId\":1},{\"id\":63,\"name\":\" 乌海市\",\"parentId\":5,\"areaId\":1},{\"id\":64,\"name\":\" 赤峰市\",\"parentId\":5,\"areaId\":1},{\"id\":65,\"name\":\" 通辽市\",\"parentId\":5,\"areaId\":1},{\"id\":66,\"name\":\" 鄂尔多斯市\",\"parentId\":5,\"areaId\":1},{\"id\":67,\"name\":\" 呼伦贝尔市\",\"parentId\":5,\"areaId\":1},{\"id\":68,\"name\":\" 巴彦淖尔市\",\"parentId\":5,\"areaId\":1},{\"id\":69,\"name\":\" 乌兰察布市\",\"parentId\":5,\"areaId\":1},{\"id\":70,\"name\":\" 兴安盟\",\"parentId\":5,\"areaId\":1},{\"id\":71,\"name\":\" 锡林郭勒盟\",\"parentId\":5,\"areaId\":1},{\"id\":72,\"name\":\" 阿拉善盟\",\"parentId\":5,\"areaId\":1},{\"id\":6,\"name\":\" 辽宁省 \",\"areaId\":2},{\"id\":73,\"name\":\" 沈阳市\",\"parentId\":6,\"areaId\":2},{\"id\":74,\"name\":\" 大连市\",\"parentId\":6,\"areaId\":2},{\"id\":75,\"name\":\" 鞍山市\",\"parentId\":6,\"areaId\":2},{\"id\":76,\"name\":\" 抚顺市\",\"parentId\":6,\"areaId\":2},{\"id\":77,\"name\":\" 本溪市\",\"parentId\":6,\"areaId\":2},{\"id\":78,\"name\":\" 丹东市\",\"parentId\":6,\"areaId\":2},{\"id\":79,\"name\":\" 锦州市\",\"parentId\":6,\"areaId\":2},{\"id\":80,\"name\":\" 营口市\",\"parentId\":6,\"areaId\":2},{\"id\":81,\"name\":\" 阜新市\",\"parentId\":6,\"areaId\":2},{\"id\":82,\"name\":\" 辽阳市\",\"parentId\":6,\"areaId\":2},{\"id\":83,\"name\":\" 盘锦市\",\"parentId\":6,\"areaId\":2},{\"id\":84,\"name\":\" 铁岭市\",\"parentId\":6,\"areaId\":2},{\"id\":85,\"name\":\" 朝阳市\",\"parentId\":6,\"areaId\":2},{\"id\":86,\"name\":\" 葫芦岛市\",\"parentId\":6,\"areaId\":2},{\"id\":7,\"name\":\" 吉林省 \",\"areaId\":2},{\"id\":87,\"name\":\" 长春市\",\"parentId\":7,\"areaId\":2},{\"id\":88,\"name\":\" 吉林市\",\"parentId\":7,\"areaId\":2},{\"id\":89,\"name\":\" 四平市\",\"parentId\":7,\"areaId\":2},{\"id\":90,\"name\":\" 辽源市\",\"parentId\":7,\"areaId\":2},{\"id\":91,\"name\":\" 通化市\",\"parentId\":7,\"areaId\":2},{\"id\":92,\"name\":\" 白山市\",\"parentId\":7,\"areaId\":2},{\"id\":93,\"name\":\" 松原市\",\"parentId\":7,\"areaId\":2},{\"id\":94,\"name\":\" 白城市\",\"parentId\":7,\"areaId\":2},{\"id\":95,\"name\":\" 延边朝鲜族自治州\",\"parentId\":7,\"areaId\":2},{\"id\":8,\"name\":\" 黑龙江省 \",\"areaId\":2},{\"id\":96,\"name\":\" 哈尔滨市\",\"parentId\":8,\"areaId\":2},{\"id\":97,\"name\":\" 齐齐哈尔市\",\"parentId\":8,\"areaId\":2},{\"id\":98,\"name\":\" 鸡西市\",\"parentId\":8,\"areaId\":2},{\"id\":99,\"name\":\" 鹤岗市\",\"parentId\":8,\"areaId\":2},{\"id\":100,\"name\":\" 双鸭山市\",\"parentId\":8,\"areaId\":2},{\"id\":101,\"name\":\" 大庆市\",\"parentId\":8,\"areaId\":2},{\"id\":102,\"name\":\" 伊春市\",\"parentId\":8,\"areaId\":2},{\"id\":103,\"name\":\" 佳木斯市\",\"parentId\":8,\"areaId\":2},{\"id\":104,\"name\":\" 七台河市\",\"parentId\":8,\"areaId\":2},{\"id\":105,\"name\":\" 牡丹江市\",\"parentId\":8,\"areaId\":2},{\"id\":106,\"name\":\" 黑河市\",\"parentId\":8,\"areaId\":2},{\"id\":107,\"name\":\" 绥化市\",\"parentId\":8,\"areaId\":2},{\"id\":108,\"name\":\" 大兴安岭地区\",\"parentId\":8,\"areaId\":2},{\"id\":9,\"name\":\" 上海市 \",\"areaId\":3},{\"id\":416,\"name\":\" 黄浦区\",\"parentId\":9,\"areaId\":3},{\"id\":417,\"name\":\" 卢湾区\",\"parentId\":9,\"areaId\":3},{\"id\":418,\"name\":\" 徐汇区\",\"parentId\":9,\"areaId\":3},{\"id\":419,\"name\":\" 长宁区\",\"parentId\":9,\"areaId\":3},{\"id\":420,\"name\":\" 静安区\",\"parentId\":9,\"areaId\":3},{\"id\":421,\"name\":\" 普陀区\",\"parentId\":9,\"areaId\":3},{\"id\":422,\"name\":\" 闸北区\",\"parentId\":9,\"areaId\":3},{\"id\":423,\"name\":\" 虹口区\",\"parentId\":9,\"areaId\":3},{\"id\":424,\"name\":\" 杨浦区\",\"parentId\":9,\"areaId\":3},{\"id\":425,\"name\":\" 闵行区\",\"parentId\":9,\"areaId\":3},{\"id\":426,\"name\":\" 宝山区\",\"parentId\":9,\"areaId\":3},{\"id\":427,\"name\":\" 嘉定区\",\"parentId\":9,\"areaId\":3},{\"id\":428,\"name\":\" 浦东新区\",\"parentId\":9,\"areaId\":3},{\"id\":429,\"name\":\" 金山区\",\"parentId\":9,\"areaId\":3},{\"id\":430,\"name\":\" 松江区\",\"parentId\":9,\"areaId\":3},{\"id\":431,\"name\":\" 青浦区\",\"parentId\":9,\"areaId\":3},{\"id\":432,\"name\":\" 南汇区\",\"parentId\":9,\"areaId\":3},{\"id\":433,\"name\":\" 奉贤区\",\"parentId\":9,\"areaId\":3},{\"id\":434,\"name\":\" 崇明县\",\"parentId\":9,\"areaId\":3},{\"id\":10,\"name\":\" 江苏省 \",\"areaId\":3},{\"id\":111,\"name\":\" 南京市\",\"parentId\":10,\"areaId\":3},{\"id\":112,\"name\":\" 无锡市\",\"parentId\":10,\"areaId\":3},{\"id\":113,\"name\":\" 徐州市\",\"parentId\":10,\"areaId\":3},{\"id\":114,\"name\":\" 常州市\",\"parentId\":10,\"areaId\":3},{\"id\":115,\"name\":\" 苏州市\",\"parentId\":10,\"areaId\":3},{\"id\":116,\"name\":\" 南通市\",\"parentId\":10,\"areaId\":3},{\"id\":117,\"name\":\" 连云港市\",\"parentId\":10,\"areaId\":3},{\"id\":118,\"name\":\" 淮安市\",\"parentId\":10,\"areaId\":3},{\"id\":119,\"name\":\" 盐城市\",\"parentId\":10,\"areaId\":3},{\"id\":120,\"name\":\" 扬州市\",\"parentId\":10,\"areaId\":3},{\"id\":121,\"name\":\" 镇江市\",\"parentId\":10,\"areaId\":3},{\"id\":122,\"name\":\" 泰州市\",\"parentId\":10,\"areaId\":3},{\"id\":123,\"name\":\" 宿迁市\",\"parentId\":10,\"areaId\":3},{\"id\":11,\"name\":\" 浙江省 \",\"areaId\":3},{\"id\":124,\"name\":\" 杭州市\",\"parentId\":11,\"areaId\":3},{\"id\":125,\"name\":\" 宁波市\",\"parentId\":11,\"areaId\":3},{\"id\":126,\"name\":\" 温州市\",\"parentId\":11,\"areaId\":3},{\"id\":127,\"name\":\" 嘉兴市\",\"parentId\":11,\"areaId\":3},{\"id\":128,\"name\":\" 湖州市\",\"parentId\":11,\"areaId\":3},{\"id\":129,\"name\":\" 绍兴市\",\"parentId\":11,\"areaId\":3},{\"id\":130,\"name\":\" 金华市\",\"parentId\":11,\"areaId\":3},{\"id\":131,\"name\":\" 衢州市\",\"parentId\":11,\"areaId\":3},{\"id\":132,\"name\":\" 舟山市\",\"parentId\":11,\"areaId\":3},{\"id\":133,\"name\":\" 台州市\",\"parentId\":11,\"areaId\":3},{\"id\":134,\"name\":\" 丽水市\",\"parentId\":11,\"areaId\":3},{\"id\":12,\"name\":\" 安徽省 \",\"areaId\":3},{\"id\":135,\"name\":\" 合肥市\",\"parentId\":12,\"areaId\":3},{\"id\":136,\"name\":\" 芜湖市\",\"parentId\":12,\"areaId\":3},{\"id\":137,\"name\":\" 蚌埠市\",\"parentId\":12,\"areaId\":3},{\"id\":138,\"name\":\" 淮南市\",\"parentId\":12,\"areaId\":3},{\"id\":139,\"name\":\" 马鞍山市\",\"parentId\":12,\"areaId\":3},{\"id\":140,\"name\":\" 淮北市\",\"parentId\":12,\"areaId\":3},{\"id\":141,\"name\":\" 铜陵市\",\"parentId\":12,\"areaId\":3},{\"id\":142,\"name\":\" 安庆市\",\"parentId\":12,\"areaId\":3},{\"id\":143,\"name\":\" 黄山市\",\"parentId\":12,\"areaId\":3},{\"id\":144,\"name\":\" 滁州市\",\"parentId\":12,\"areaId\":3},{\"id\":145,\"name\":\" 阜阳市\",\"parentId\":12,\"areaId\":3},{\"id\":146,\"name\":\" 宿州市\",\"parentId\":12,\"areaId\":3},{\"id\":147,\"name\":\" 巢湖市\",\"parentId\":12,\"areaId\":3},{\"id\":148,\"name\":\" 六安市\",\"parentId\":12,\"areaId\":3},{\"id\":149,\"name\":\" 亳州市\",\"parentId\":12,\"areaId\":3},{\"id\":150,\"name\":\" 池州市\",\"parentId\":12,\"areaId\":3},{\"id\":151,\"name\":\" 宣城市\",\"parentId\":12,\"areaId\":3},{\"id\":13,\"name\":\" 福建省 \",\"areaId\":3},{\"id\":152,\"name\":\" 福州市\",\"parentId\":13,\"areaId\":3},{\"id\":153,\"name\":\" 厦门市\",\"parentId\":13,\"areaId\":3},{\"id\":154,\"name\":\" 莆田市\",\"parentId\":13,\"areaId\":3},{\"id\":155,\"name\":\" 三明市\",\"parentId\":13,\"areaId\":3},{\"id\":156,\"name\":\" 泉州市\",\"parentId\":13,\"areaId\":3},{\"id\":157,\"name\":\" 漳州市\",\"parentId\":13,\"areaId\":3},{\"id\":158,\"name\":\" 南平市\",\"parentId\":13,\"areaId\":3},{\"id\":159,\"name\":\" 龙岩市\",\"parentId\":13,\"areaId\":3},{\"id\":160,\"name\":\" 宁德市\",\"parentId\":13,\"areaId\":3},{\"id\":14,\"name\":\" 江西省 \",\"areaId\":3},{\"id\":161,\"name\":\" 南昌市\",\"parentId\":14,\"areaId\":3},{\"id\":162,\"name\":\" 景德镇市\",\"parentId\":14,\"areaId\":3},{\"id\":163,\"name\":\" 萍乡市\",\"parentId\":14,\"areaId\":3},{\"id\":164,\"name\":\" 九江市\",\"parentId\":14,\"areaId\":3},{\"id\":165,\"name\":\" 新余市\",\"parentId\":14,\"areaId\":3},{\"id\":166,\"name\":\" 鹰潭市\",\"parentId\":14,\"areaId\":3},{\"id\":167,\"name\":\" 赣州市\",\"parentId\":14,\"areaId\":3},{\"id\":168,\"name\":\" 吉安市\",\"parentId\":14,\"areaId\":3},{\"id\":169,\"name\":\" 宜春市\",\"parentId\":14,\"areaId\":3},{\"id\":170,\"name\":\" 抚州市\",\"parentId\":14,\"areaId\":3},{\"id\":171,\"name\":\" 上饶市\",\"parentId\":14,\"areaId\":3},{\"id\":15,\"name\":\" 山东省 \",\"areaId\":3},{\"id\":172,\"name\":\" 济南市\",\"parentId\":15,\"areaId\":3},{\"id\":173,\"name\":\" 青岛市\",\"parentId\":15,\"areaId\":3},{\"id\":174,\"name\":\" 淄博市\",\"parentId\":15,\"areaId\":3},{\"id\":175,\"name\":\" 枣庄市\",\"parentId\":15,\"areaId\":3},{\"id\":176,\"name\":\" 东营市\",\"parentId\":15,\"areaId\":3},{\"id\":177,\"name\":\" 烟台市\",\"parentId\":15,\"areaId\":3},{\"id\":178,\"name\":\" 潍坊市\",\"parentId\":15,\"areaId\":3},{\"id\":179,\"name\":\" 济宁市\",\"parentId\":15,\"areaId\":3},{\"id\":180,\"name\":\" 泰安市\",\"parentId\":15,\"areaId\":3},{\"id\":181,\"name\":\" 威海市\",\"parentId\":15,\"areaId\":3},{\"id\":182,\"name\":\" 日照市\",\"parentId\":15,\"areaId\":3},{\"id\":183,\"name\":\" 莱芜市\",\"parentId\":15,\"areaId\":3},{\"id\":184,\"name\":\" 临沂市\",\"parentId\":15,\"areaId\":3},{\"id\":185,\"name\":\" 德州市\",\"parentId\":15,\"areaId\":3},{\"id\":186,\"name\":\" 聊城市\",\"parentId\":15,\"areaId\":3},{\"id\":187,\"name\":\" 滨州市\",\"parentId\":15,\"areaId\":3},{\"id\":188,\"name\":\" 荷泽市\",\"parentId\":15,\"areaId\":3},{\"id\":16,\"name\":\" 河南省 \",\"areaId\":4},{\"id\":189,\"name\":\" 郑州市\",\"parentId\":16,\"areaId\":4},{\"id\":190,\"name\":\" 开封市\",\"parentId\":16,\"areaId\":4},{\"id\":191,\"name\":\" 洛阳市\",\"parentId\":16,\"areaId\":4},{\"id\":192,\"name\":\" 平顶山市\",\"parentId\":16,\"areaId\":4},{\"id\":193,\"name\":\" 安阳市\",\"parentId\":16,\"areaId\":4},{\"id\":194,\"name\":\" 鹤壁市\",\"parentId\":16,\"areaId\":4},{\"id\":195,\"name\":\" 新乡市\",\"parentId\":16,\"areaId\":4},{\"id\":196,\"name\":\" 焦作市\",\"parentId\":16,\"areaId\":4},{\"id\":197,\"name\":\" 濮阳市\",\"parentId\":16,\"areaId\":4},{\"id\":198,\"name\":\" 许昌市\",\"parentId\":16,\"areaId\":4},{\"id\":199,\"name\":\" 漯河市\",\"parentId\":16,\"areaId\":4},{\"id\":200,\"name\":\" 三门峡市\",\"parentId\":16,\"areaId\":4},{\"id\":201,\"name\":\" 南阳市\",\"parentId\":16,\"areaId\":4},{\"id\":202,\"name\":\" 商丘市\",\"parentId\":16,\"areaId\":4},{\"id\":203,\"name\":\" 信阳市\",\"parentId\":16,\"areaId\":4},{\"id\":204,\"name\":\" 周口市\",\"parentId\":16,\"areaId\":4},{\"id\":205,\"name\":\" 驻马店市\",\"parentId\":16,\"areaId\":4},{\"id\":17,\"name\":\" 湖北省 \",\"areaId\":4},{\"id\":206,\"name\":\" 武汉市\",\"parentId\":17,\"areaId\":4},{\"id\":207,\"name\":\" 黄石市\",\"parentId\":17,\"areaId\":4},{\"id\":208,\"name\":\" 十堰市\",\"parentId\":17,\"areaId\":4},{\"id\":209,\"name\":\" 宜昌市\",\"parentId\":17,\"areaId\":4},{\"id\":210,\"name\":\" 襄樊市\",\"parentId\":17,\"areaId\":4},{\"id\":211,\"name\":\" 鄂州市\",\"parentId\":17,\"areaId\":4},{\"id\":212,\"name\":\" 荆门市\",\"parentId\":17,\"areaId\":4},{\"id\":213,\"name\":\" 孝感市\",\"parentId\":17,\"areaId\":4},{\"id\":214,\"name\":\" 荆州市\",\"parentId\":17,\"areaId\":4},{\"id\":215,\"name\":\" 黄冈市\",\"parentId\":17,\"areaId\":4},{\"id\":216,\"name\":\" 咸宁市\",\"parentId\":17,\"areaId\":4},{\"id\":217,\"name\":\" 随州市\",\"parentId\":17,\"areaId\":4},{\"id\":218,\"name\":\" 恩施土家族苗族自治州\",\"parentId\":17,\"areaId\":4},{\"id\":18,\"name\":\" 湖南省 \",\"areaId\":4},{\"id\":220,\"name\":\" 长沙市\",\"parentId\":18,\"areaId\":4},{\"id\":221,\"name\":\" 株洲市\",\"parentId\":18,\"areaId\":4},{\"id\":222,\"name\":\" 湘潭市\",\"parentId\":18,\"areaId\":4},{\"id\":223,\"name\":\" 衡阳市\",\"parentId\":18,\"areaId\":4},{\"id\":224,\"name\":\" 邵阳市\",\"parentId\":18,\"areaId\":4},{\"id\":225,\"name\":\" 岳阳市\",\"parentId\":18,\"areaId\":4},{\"id\":226,\"name\":\" 常德市\",\"parentId\":18,\"areaId\":4},{\"id\":227,\"name\":\" 张家界市\",\"parentId\":18,\"areaId\":4},{\"id\":228,\"name\":\" 益阳市\",\"parentId\":18,\"areaId\":4},{\"id\":229,\"name\":\" 郴州市\",\"parentId\":18,\"areaId\":4},{\"id\":230,\"name\":\" 永州市\",\"parentId\":18,\"areaId\":4},{\"id\":231,\"name\":\" 怀化市\",\"parentId\":18,\"areaId\":4},{\"id\":232,\"name\":\" 娄底市\",\"parentId\":18,\"areaId\":4},{\"id\":233,\"name\":\" 湘西土家族苗族自治州\",\"parentId\":18,\"areaId\":4},{\"id\":19,\"name\":\" 广东省 \",\"areaId\":4},{\"id\":234,\"name\":\" 广州市\",\"parentId\":19,\"areaId\":4},{\"id\":235,\"name\":\" 韶关市\",\"parentId\":19,\"areaId\":4},{\"id\":236,\"name\":\" 深圳市\",\"parentId\":19,\"areaId\":4},{\"id\":237,\"name\":\" 珠海市\",\"parentId\":19,\"areaId\":4},{\"id\":238,\"name\":\" 汕头市\",\"parentId\":19,\"areaId\":4},{\"id\":239,\"name\":\" 佛山市\",\"parentId\":19,\"areaId\":4},{\"id\":240,\"name\":\" 江门市\",\"parentId\":19,\"areaId\":4},{\"id\":241,\"name\":\" 湛江市\",\"parentId\":19,\"areaId\":4},{\"id\":242,\"name\":\" 茂名市\",\"parentId\":19,\"areaId\":4},{\"id\":243,\"name\":\" 肇庆市\",\"parentId\":19,\"areaId\":4},{\"id\":244,\"name\":\" 惠州市\",\"parentId\":19,\"areaId\":4},{\"id\":245,\"name\":\" 梅州市\",\"parentId\":19,\"areaId\":4},{\"id\":246,\"name\":\" 汕尾市\",\"parentId\":19,\"areaId\":4},{\"id\":247,\"name\":\" 河源市\",\"parentId\":19,\"areaId\":4},{\"id\":248,\"name\":\" 阳江市\",\"parentId\":19,\"areaId\":4},{\"id\":249,\"name\":\" 清远市\",\"parentId\":19,\"areaId\":4},{\"id\":250,\"name\":\" 东莞市\",\"parentId\":19,\"areaId\":4},{\"id\":251,\"name\":\" 中山市\",\"parentId\":19,\"areaId\":4},{\"id\":252,\"name\":\" 潮州市\",\"parentId\":19,\"areaId\":4},{\"id\":253,\"name\":\" 揭阳市\",\"parentId\":19,\"areaId\":4},{\"id\":254,\"name\":\" 云浮市\",\"parentId\":19,\"areaId\":4},{\"id\":20,\"name\":\" 广西 \",\"areaId\":4},{\"id\":256,\"name\":\" 柳州市\",\"parentId\":20,\"areaId\":4},{\"id\":257,\"name\":\" 桂林市\",\"parentId\":20,\"areaId\":4},{\"id\":258,\"name\":\" 梧州市\",\"parentId\":20,\"areaId\":4},{\"id\":259,\"name\":\" 北海市\",\"parentId\":20,\"areaId\":4},{\"id\":260,\"name\":\" 防城港市\",\"parentId\":20,\"areaId\":4},{\"id\":261,\"name\":\" 钦州市\",\"parentId\":20,\"areaId\":4},{\"id\":262,\"name\":\" 贵港市\",\"parentId\":20,\"areaId\":4},{\"id\":263,\"name\":\" 玉林市\",\"parentId\":20,\"areaId\":4},{\"id\":264,\"name\":\" 百色市\",\"parentId\":20,\"areaId\":4},{\"id\":265,\"name\":\" 贺州市\",\"parentId\":20,\"areaId\":4},{\"id\":266,\"name\":\" 河池市\",\"parentId\":20,\"areaId\":4},{\"id\":267,\"name\":\" 来宾市\",\"parentId\":20,\"areaId\":4},{\"id\":268,\"name\":\" 崇左市\",\"parentId\":20,\"areaId\":4},{\"id\":255,\"name\":\" 南宁市\",\"parentId\":20,\"areaId\":4},{\"id\":21,\"name\":\" 海南省 \",\"areaId\":4},{\"id\":269,\"name\":\" 海口市\",\"parentId\":21,\"areaId\":4},{\"id\":270,\"name\":\" 三亚市\",\"parentId\":21,\"areaId\":4},{\"id\":271,\"name\":\" 省直辖县级行政单位\",\"parentId\":21,\"areaId\":4},{\"id\":22,\"name\":\" 重庆市 \",\"areaId\":5},{\"id\":435,\"name\":\" 万州区\",\"parentId\":22,\"areaId\":5},{\"id\":436,\"name\":\" 涪陵区\",\"parentId\":22,\"areaId\":5},{\"id\":437,\"name\":\" 渝中区\",\"parentId\":22,\"areaId\":5},{\"id\":438,\"name\":\" 大渡口区\",\"parentId\":22,\"areaId\":5},{\"id\":439,\"name\":\" 江北区\",\"parentId\":22,\"areaId\":5},{\"id\":440,\"name\":\" 沙坪坝区\",\"parentId\":22,\"areaId\":5},{\"id\":441,\"name\":\" 九龙坡区\",\"parentId\":22,\"areaId\":5},{\"id\":442,\"name\":\" 南岸区\",\"parentId\":22,\"areaId\":5},{\"id\":443,\"name\":\" 北碚区\",\"parentId\":22,\"areaId\":5},{\"id\":444,\"name\":\" 万盛区\",\"parentId\":22,\"areaId\":5},{\"id\":445,\"name\":\" 双桥区\",\"parentId\":22,\"areaId\":5},{\"id\":446,\"name\":\" 渝北区\",\"parentId\":22,\"areaId\":5},{\"id\":447,\"name\":\" 巴南区\",\"parentId\":22,\"areaId\":5},{\"id\":448,\"name\":\" 黔江区\",\"parentId\":22,\"areaId\":5},{\"id\":449,\"name\":\" 长寿区\",\"parentId\":22,\"areaId\":5},{\"id\":450,\"name\":\" 綦江县\",\"parentId\":22,\"areaId\":5},{\"id\":451,\"name\":\" 潼南县\",\"parentId\":22,\"areaId\":5},{\"id\":452,\"name\":\" 铜梁县\",\"parentId\":22,\"areaId\":5},{\"id\":453,\"name\":\" 大足县\",\"parentId\":22,\"areaId\":5},{\"id\":454,\"name\":\" 荣昌县\",\"parentId\":22,\"areaId\":5},{\"id\":455,\"name\":\" 璧山县\",\"parentId\":22,\"areaId\":5},{\"id\":456,\"name\":\" 梁平县\",\"parentId\":22,\"areaId\":5},{\"id\":457,\"name\":\" 城口县\",\"parentId\":22,\"areaId\":5},{\"id\":458,\"name\":\" 丰都县\",\"parentId\":22,\"areaId\":5},{\"id\":459,\"name\":\" 垫江县\",\"parentId\":22,\"areaId\":5},{\"id\":460,\"name\":\" 武隆县\",\"parentId\":22,\"areaId\":5},{\"id\":461,\"name\":\" 忠　县\",\"parentId\":22,\"areaId\":5},{\"id\":462,\"name\":\" 开　县\",\"parentId\":22,\"areaId\":5},{\"id\":463,\"name\":\" 云阳县\",\"parentId\":22,\"areaId\":5},{\"id\":464,\"name\":\" 奉节县\",\"parentId\":22,\"areaId\":5},{\"id\":465,\"name\":\" 巫山县\",\"parentId\":22,\"areaId\":5},{\"id\":466,\"name\":\" 巫溪县\",\"parentId\":22,\"areaId\":5},{\"id\":467,\"name\":\" 石柱土家族自治县\",\"parentId\":22,\"areaId\":5},{\"id\":468,\"name\":\" 秀山土家族苗族自治县\",\"parentId\":22,\"areaId\":5},{\"id\":469,\"name\":\" 酉阳土家族苗族自治县\",\"parentId\":22,\"areaId\":5},{\"id\":470,\"name\":\" 彭水苗族土家族自治县\",\"parentId\":22,\"areaId\":5},{\"id\":471,\"name\":\" 江津市\",\"parentId\":22,\"areaId\":5},{\"id\":472,\"name\":\" 合川市\",\"parentId\":22,\"areaId\":5},{\"id\":473,\"name\":\" 永川市\",\"parentId\":22,\"areaId\":5},{\"id\":474,\"name\":\" 南川市\",\"parentId\":22,\"areaId\":5},{\"id\":23,\"name\":\" 四川省 \",\"areaId\":5},{\"id\":275,\"name\":\" 成都市\",\"parentId\":23,\"areaId\":5},{\"id\":276,\"name\":\" 自贡市\",\"parentId\":23,\"areaId\":5},{\"id\":277,\"name\":\" 攀枝花市\",\"parentId\":23,\"areaId\":5},{\"id\":278,\"name\":\" 泸州市\",\"parentId\":23,\"areaId\":5},{\"id\":279,\"name\":\" 德阳市\",\"parentId\":23,\"areaId\":5},{\"id\":280,\"name\":\" 绵阳市\",\"parentId\":23,\"areaId\":5},{\"id\":281,\"name\":\" 广元市\",\"parentId\":23,\"areaId\":5},{\"id\":282,\"name\":\" 遂宁市\",\"parentId\":23,\"areaId\":5},{\"id\":283,\"name\":\" 内江市\",\"parentId\":23,\"areaId\":5},{\"id\":284,\"name\":\" 乐山市\",\"parentId\":23,\"areaId\":5},{\"id\":285,\"name\":\" 南充市\",\"parentId\":23,\"areaId\":5},{\"id\":286,\"name\":\" 眉山市\",\"parentId\":23,\"areaId\":5},{\"id\":287,\"name\":\" 宜宾市\",\"parentId\":23,\"areaId\":5},{\"id\":288,\"name\":\" 广安市\",\"parentId\":23,\"areaId\":5},{\"id\":289,\"name\":\" 达州市\",\"parentId\":23,\"areaId\":5},{\"id\":290,\"name\":\" 雅安市\",\"parentId\":23,\"areaId\":5},{\"id\":291,\"name\":\" 巴中市\",\"parentId\":23,\"areaId\":5},{\"id\":292,\"name\":\" 资阳市\",\"parentId\":23,\"areaId\":5},{\"id\":293,\"name\":\" 阿坝藏族羌族自治州\",\"parentId\":23,\"areaId\":5},{\"id\":294,\"name\":\" 甘孜藏族自治州\",\"parentId\":23,\"areaId\":5},{\"id\":295,\"name\":\" 凉山彝族自治州\",\"parentId\":23,\"areaId\":5},{\"id\":24,\"name\":\" 贵州省 \",\"areaId\":5},{\"id\":296,\"name\":\" 贵阳市\",\"parentId\":24,\"areaId\":5},{\"id\":297,\"name\":\" 六盘水市\",\"parentId\":24,\"areaId\":5},{\"id\":298,\"name\":\" 遵义市\",\"parentId\":24,\"areaId\":5},{\"id\":299,\"name\":\" 安顺市\",\"parentId\":24,\"areaId\":5},{\"id\":300,\"name\":\" 铜仁地区\",\"parentId\":24,\"areaId\":5},{\"id\":301,\"name\":\" 黔西南布依族苗族自治州\",\"parentId\":24,\"areaId\":5},{\"id\":302,\"name\":\" 毕节地区\",\"parentId\":24,\"areaId\":5},{\"id\":303,\"name\":\" 黔东南苗族侗族自治州\",\"parentId\":24,\"areaId\":5},{\"id\":304,\"name\":\" 黔南布依族苗族自治州\",\"parentId\":24,\"areaId\":5},{\"id\":25,\"name\":\" 云南省 \",\"areaId\":5},{\"id\":305,\"name\":\" 昆明市\",\"parentId\":25,\"areaId\":5},{\"id\":306,\"name\":\" 曲靖市\",\"parentId\":25,\"areaId\":5},{\"id\":307,\"name\":\" 玉溪市\",\"parentId\":25,\"areaId\":5},{\"id\":308,\"name\":\" 保山市\",\"parentId\":25,\"areaId\":5},{\"id\":309,\"name\":\" 昭通市\",\"parentId\":25,\"areaId\":5},{\"id\":310,\"name\":\" 丽江市\",\"parentId\":25,\"areaId\":5},{\"id\":311,\"name\":\" 思茅市\",\"parentId\":25,\"areaId\":5},{\"id\":312,\"name\":\" 临沧市\",\"parentId\":25,\"areaId\":5},{\"id\":313,\"name\":\" 楚雄彝族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":314,\"name\":\" 红河哈尼族彝族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":315,\"name\":\" 文山壮族苗族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":316,\"name\":\" 西双版纳傣族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":317,\"name\":\" 大理白族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":318,\"name\":\" 德宏傣族景颇族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":319,\"name\":\" 怒江傈僳族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":320,\"name\":\" 迪庆藏族自治州\",\"parentId\":25,\"areaId\":5},{\"id\":26,\"name\":\" 西藏 \",\"areaId\":5},{\"id\":321,\"name\":\" 拉萨市\",\"parentId\":26,\"areaId\":5},{\"id\":322,\"name\":\" 昌都地区\",\"parentId\":26,\"areaId\":5},{\"id\":323,\"name\":\" 山南地区\",\"parentId\":26,\"areaId\":5},{\"id\":324,\"name\":\" 日喀则地区\",\"parentId\":26,\"areaId\":5},{\"id\":325,\"name\":\" 那曲地区\",\"parentId\":26,\"areaId\":5},{\"id\":326,\"name\":\" 阿里地区\",\"parentId\":26,\"areaId\":5},{\"id\":327,\"name\":\" 林芝地区\",\"parentId\":26,\"areaId\":5},{\"id\":27,\"name\":\" 陕西省 \",\"areaId\":6},{\"id\":328,\"name\":\" 西安市\",\"parentId\":27,\"areaId\":6},{\"id\":329,\"name\":\" 铜川市\",\"parentId\":27,\"areaId\":6},{\"id\":330,\"name\":\" 宝鸡市\",\"parentId\":27,\"areaId\":6},{\"id\":331,\"name\":\" 咸阳市\",\"parentId\":27,\"areaId\":6},{\"id\":332,\"name\":\" 渭南市\",\"parentId\":27,\"areaId\":6},{\"id\":333,\"name\":\" 延安市\",\"parentId\":27,\"areaId\":6},{\"id\":334,\"name\":\" 汉中市\",\"parentId\":27,\"areaId\":6},{\"id\":335,\"name\":\" 榆林市\",\"parentId\":27,\"areaId\":6},{\"id\":336,\"name\":\" 安康市\",\"parentId\":27,\"areaId\":6},{\"id\":337,\"name\":\" 商洛市\",\"parentId\":27,\"areaId\":6},{\"id\":28,\"name\":\" 甘肃省 \",\"areaId\":6},{\"id\":338,\"name\":\" 兰州市\",\"parentId\":28,\"areaId\":6},{\"id\":339,\"name\":\" 嘉峪关市\",\"parentId\":28,\"areaId\":6},{\"id\":340,\"name\":\" 金昌市\",\"parentId\":28,\"areaId\":6},{\"id\":341,\"name\":\" 白银市\",\"parentId\":28,\"areaId\":6},{\"id\":342,\"name\":\" 天水市\",\"parentId\":28,\"areaId\":6},{\"id\":343,\"name\":\" 武威市\",\"parentId\":28,\"areaId\":6},{\"id\":344,\"name\":\" 张掖市\",\"parentId\":28,\"areaId\":6},{\"id\":345,\"name\":\" 平凉市\",\"parentId\":28,\"areaId\":6},{\"id\":346,\"name\":\" 酒泉市\",\"parentId\":28,\"areaId\":6},{\"id\":347,\"name\":\" 庆阳市\",\"parentId\":28,\"areaId\":6},{\"id\":348,\"name\":\" 定西市\",\"parentId\":28,\"areaId\":6},{\"id\":349,\"name\":\" 陇南市\",\"parentId\":28,\"areaId\":6},{\"id\":350,\"name\":\" 临夏自治州\",\"parentId\":28,\"areaId\":6},{\"id\":351,\"name\":\" 甘南藏族自治州\",\"parentId\":28,\"areaId\":6},{\"id\":29,\"name\":\" 青海省 \",\"areaId\":6},{\"id\":352,\"name\":\" 西宁市\",\"parentId\":29,\"areaId\":6},{\"id\":353,\"name\":\" 海东地区\",\"parentId\":29,\"areaId\":6},{\"id\":354,\"name\":\" 海北藏族自治州\",\"parentId\":29,\"areaId\":6},{\"id\":355,\"name\":\" 黄南藏族自治州\",\"parentId\":29,\"areaId\":6},{\"id\":356,\"name\":\" 海南藏族自治州\",\"parentId\":29,\"areaId\":6},{\"id\":357,\"name\":\" 果洛藏族自治州\",\"parentId\":29,\"areaId\":6},{\"id\":358,\"name\":\" 玉树藏族自治州\",\"parentId\":29,\"areaId\":6},{\"id\":359,\"name\":\" 海西蒙古族藏族自治州\",\"parentId\":29,\"areaId\":6},{\"id\":30,\"name\":\" 宁夏 \",\"areaId\":6},{\"id\":360,\"name\":\" 银川市\",\"parentId\":30,\"areaId\":6},{\"id\":361,\"name\":\" 石嘴山市\",\"parentId\":30,\"areaId\":6},{\"id\":362,\"name\":\" 吴忠市\",\"parentId\":30,\"areaId\":6},{\"id\":363,\"name\":\" 固原市\",\"parentId\":30,\"areaId\":6},{\"id\":364,\"name\":\" 中卫市\",\"parentId\":30,\"areaId\":6},{\"id\":31,\"name\":\" 新疆 \",\"areaId\":6},{\"id\":365,\"name\":\" 乌鲁木齐市\",\"parentId\":31,\"areaId\":6},{\"id\":366,\"name\":\" 克拉玛依市\",\"parentId\":31,\"areaId\":6},{\"id\":367,\"name\":\" 吐鲁番地区\",\"parentId\":31,\"areaId\":6},{\"id\":368,\"name\":\" 哈密地区\",\"parentId\":31,\"areaId\":6},{\"id\":369,\"name\":\" 昌吉自治州\",\"parentId\":31,\"areaId\":6},{\"id\":370,\"name\":\" 博尔塔拉蒙古自治州\",\"parentId\":31,\"areaId\":6},{\"id\":371,\"name\":\" 巴音郭楞蒙古自治州\",\"parentId\":31,\"areaId\":6},{\"id\":372,\"name\":\" 阿克苏地区\",\"parentId\":31,\"areaId\":6},{\"id\":373,\"name\":\" 克孜勒苏柯尔克孜自治州\",\"parentId\":31,\"areaId\":6},{\"id\":374,\"name\":\" 喀什地区\",\"parentId\":31,\"areaId\":6},{\"id\":375,\"name\":\" 和田地区\",\"parentId\":31,\"areaId\":6},{\"id\":376,\"name\":\" 伊犁哈萨克自治州\",\"parentId\":31,\"areaId\":6},{\"id\":377,\"name\":\" 塔城地区\",\"parentId\":31,\"areaId\":6},{\"id\":378,\"name\":\" 阿勒泰地区\",\"parentId\":31,\"areaId\":6}],\"type\":\"1\"}";
        List<DtlAddressDto> dtlAddressDtos =  JSONArray.parseArray(dtl_address,DtlAddressDto.class);
        if (dtlAddressDtos==null){
            dtlAddressDtos = new ArrayList<>();
        }
    }
}
