package com.at.entity.mapper;

import com.at.entity.NewTable;
import com.at.entity.NewTableCriteria.Criteria;
import com.at.entity.NewTableCriteria.Criterion;
import com.at.entity.NewTableCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class NewTableSqlProvider {

    public String countByExample(NewTableCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("new_table");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(NewTableCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("new_table");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(NewTable record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("new_table");
        
        if (record.getIdnewTable() != null) {
            sql.VALUES("idnew_table", "#{idnewTable,jdbcType=INTEGER}");
        }
        
        if (record.getNewTablecol() != null) {
            sql.VALUES("new_tablecol", "#{newTablecol,jdbcType=VARCHAR}");
        }
        
        if (record.getNewTablecol1() != null) {
            sql.VALUES("new_tablecol1", "#{newTablecol1,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(NewTableCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("idnew_table");
        } else {
            sql.SELECT("idnew_table");
        }
        sql.SELECT("new_tablecol");
        sql.SELECT("new_tablecol1");
        sql.FROM("new_table");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        NewTable record = (NewTable) parameter.get("record");
        NewTableCriteria example = (NewTableCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("new_table");
        
        if (record.getIdnewTable() != null) {
            sql.SET("idnew_table = #{record.idnewTable,jdbcType=INTEGER}");
        }
        
        if (record.getNewTablecol() != null) {
            sql.SET("new_tablecol = #{record.newTablecol,jdbcType=VARCHAR}");
        }
        
        if (record.getNewTablecol1() != null) {
            sql.SET("new_tablecol1 = #{record.newTablecol1,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("new_table");
        
        sql.SET("idnew_table = #{record.idnewTable,jdbcType=INTEGER}");
        sql.SET("new_tablecol = #{record.newTablecol,jdbcType=VARCHAR}");
        sql.SET("new_tablecol1 = #{record.newTablecol1,jdbcType=VARCHAR}");
        
        NewTableCriteria example = (NewTableCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NewTable record) {
        SQL sql = new SQL();
        sql.UPDATE("new_table");
        
        if (record.getNewTablecol() != null) {
            sql.SET("new_tablecol = #{newTablecol,jdbcType=VARCHAR}");
        }
        
        if (record.getNewTablecol1() != null) {
            sql.SET("new_tablecol1 = #{newTablecol1,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("idnew_table = #{idnewTable,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NewTableCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}