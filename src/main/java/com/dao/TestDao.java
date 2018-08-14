package com.dao;

import com.comment.BaseDao;
import com.control.TestControl;
import com.model.AppNewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by daixuan on 2018/6/26 15:06
 */
@Component("testdao")
public class TestDao extends BaseDao{
    private final static Logger logger = LoggerFactory.getLogger(TestDao.class);

    /**
     *
     * @return
     */
    public List<AppNewDto> appNewDtos(){
        String sql = "SELECT * FROM app_new a WHERE a.app_name is NULL";
        List<AppNewDto> appNewDtoList =  getZcdsptestJdbcTemplate().query(sql,new BeanPropertyRowMapper<>(AppNewDto.class));
        return appNewDtoList;
    }

    public void batchUpdate(List<AppNewDto> appNewDtos){
        String sql = "UPDATE app_new SET app_name=? WHERE package_name=? ";
        getZcdsptestJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                AppNewDto appNewDto = appNewDtos.get(i);
                ps.setString(1,appNewDto.getApp_name());
                ps.setString(2,appNewDto.getPackage_name());
            }

            @Override
            public int getBatchSize() {
                return appNewDtos.size();
            }
        });
    }
}
