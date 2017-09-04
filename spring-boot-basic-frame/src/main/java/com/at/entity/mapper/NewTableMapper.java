package com.at.entity.mapper;

import com.at.entity.NewTable;
import com.at.entity.NewTableCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NewTableMapper {
    @SelectProvider(type=NewTableSqlProvider.class, method="countByExample")
    long countByExample(NewTableCriteria example);

    @DeleteProvider(type=NewTableSqlProvider.class, method="deleteByExample")
    int deleteByExample(NewTableCriteria example);

    @Delete({
        "delete from new_table",
        "where idnew_table = #{idnewTable,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idnewTable);

    @Insert({
        "insert into new_table (idnew_table, new_tablecol, ",
        "new_tablecol1)",
        "values (#{idnewTable,jdbcType=INTEGER}, #{newTablecol,jdbcType=VARCHAR}, ",
        "#{newTablecol1,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "idnewTable")
    int insert(NewTable record);

    @InsertProvider(type=NewTableSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "idnewTable")
    int insertSelective(NewTable record);

    @SelectProvider(type=NewTableSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="idnew_table", property="idnewTable", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="new_tablecol", property="newTablecol", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_tablecol1", property="newTablecol1", jdbcType=JdbcType.VARCHAR)
    })
    List<NewTable> selectByExample(NewTableCriteria example);

    @Select({
        "select",
        "idnew_table, new_tablecol, new_tablecol1",
        "from new_table",
        "where idnew_table = #{idnewTable,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="idnew_table", property="idnewTable", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="new_tablecol", property="newTablecol", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_tablecol1", property="newTablecol1", jdbcType=JdbcType.VARCHAR)
    })
    NewTable selectByPrimaryKey(Integer idnewTable);

    @UpdateProvider(type=NewTableSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NewTable record, @Param("example") NewTableCriteria example);

    @UpdateProvider(type=NewTableSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NewTable record, @Param("example") NewTableCriteria example);

    @UpdateProvider(type=NewTableSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NewTable record);

    @Update({
        "update new_table",
        "set new_tablecol = #{newTablecol,jdbcType=VARCHAR},",
          "new_tablecol1 = #{newTablecol1,jdbcType=VARCHAR}",
        "where idnew_table = #{idnewTable,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NewTable record);

    @SelectProvider(type=com.at.entity.mapper.NewTableSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="idnew_table", property="idnewTable", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="new_tablecol", property="newTablecol", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_tablecol1", property="newTablecol1", jdbcType=JdbcType.VARCHAR)
    })
    NewTable getByExample(NewTableCriteria example);

    @Select({
    "select * from",
    "new_table"
    })
    @Results({
        @Result(column="idnew_table", property="idnewTable", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="new_tablecol", property="newTablecol", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_tablecol1", property="newTablecol1", jdbcType=JdbcType.VARCHAR)
    })
    List<NewTable> selectAll();
}