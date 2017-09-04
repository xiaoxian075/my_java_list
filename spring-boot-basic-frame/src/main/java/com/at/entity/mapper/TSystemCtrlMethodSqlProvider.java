package com.at.entity.mapper;

import com.at.entity.TSystemCtrlMethod;
import com.at.entity.TSystemCtrlMethodCriteria.Criteria;
import com.at.entity.TSystemCtrlMethodCriteria.Criterion;
import com.at.entity.TSystemCtrlMethodCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TSystemCtrlMethodSqlProvider {

    public String countByExample(TSystemCtrlMethodCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_system_ctrl_method");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TSystemCtrlMethodCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_system_ctrl_method");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TSystemCtrlMethod record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_system_ctrl_method");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMethodId() != null) {
            sql.VALUES("method_id", "#{methodId,jdbcType=INTEGER}");
        }
        
        if (record.getCtrlId() != null) {
            sql.VALUES("ctrl_id", "#{ctrlId,jdbcType=INTEGER}");
        }
        
        if (record.getMethodName() != null) {
            sql.VALUES("method_name", "#{methodName,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodDesc() != null) {
            sql.VALUES("method_desc", "#{methodDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodVersion() != null) {
            sql.VALUES("method_version", "#{methodVersion,jdbcType=INTEGER}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.VALUES("last_update_time", "#{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TSystemCtrlMethodCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("method_id");
        sql.SELECT("ctrl_id");
        sql.SELECT("method_name");
        sql.SELECT("method_desc");
        sql.SELECT("method_version");
        sql.SELECT("last_update_time");
        sql.FROM("t_system_ctrl_method");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TSystemCtrlMethod record = (TSystemCtrlMethod) parameter.get("record");
        TSystemCtrlMethodCriteria example = (TSystemCtrlMethodCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_system_ctrl_method");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getMethodId() != null) {
            sql.SET("method_id = #{record.methodId,jdbcType=INTEGER}");
        }
        
        if (record.getCtrlId() != null) {
            sql.SET("ctrl_id = #{record.ctrlId,jdbcType=INTEGER}");
        }
        
        if (record.getMethodName() != null) {
            sql.SET("method_name = #{record.methodName,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodDesc() != null) {
            sql.SET("method_desc = #{record.methodDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodVersion() != null) {
            sql.SET("method_version = #{record.methodVersion,jdbcType=INTEGER}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.SET("last_update_time = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_system_ctrl_method");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("method_id = #{record.methodId,jdbcType=INTEGER}");
        sql.SET("ctrl_id = #{record.ctrlId,jdbcType=INTEGER}");
        sql.SET("method_name = #{record.methodName,jdbcType=VARCHAR}");
        sql.SET("method_desc = #{record.methodDesc,jdbcType=VARCHAR}");
        sql.SET("method_version = #{record.methodVersion,jdbcType=INTEGER}");
        sql.SET("last_update_time = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        
        TSystemCtrlMethodCriteria example = (TSystemCtrlMethodCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TSystemCtrlMethod record) {
        SQL sql = new SQL();
        sql.UPDATE("t_system_ctrl_method");
        
        if (record.getMethodId() != null) {
            sql.SET("method_id = #{methodId,jdbcType=INTEGER}");
        }
        
        if (record.getCtrlId() != null) {
            sql.SET("ctrl_id = #{ctrlId,jdbcType=INTEGER}");
        }
        
        if (record.getMethodName() != null) {
            sql.SET("method_name = #{methodName,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodDesc() != null) {
            sql.SET("method_desc = #{methodDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodVersion() != null) {
            sql.SET("method_version = #{methodVersion,jdbcType=INTEGER}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.SET("last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TSystemCtrlMethodCriteria example, boolean includeExamplePhrase) {
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