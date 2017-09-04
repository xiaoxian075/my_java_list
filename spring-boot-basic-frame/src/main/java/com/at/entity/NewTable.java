package com.at.entity;

import io.swagger.annotations.ApiModelProperty;

public class NewTable {
    private Integer idnewTable;

    private String newTablecol;

    private String newTablecol1;

    public static final String IDNEW_TABLE_ASC = "idnew_table ASC";

    public static final String IDNEW_TABLE_DESC = "idnew_table DESC";

    public static final String NEW_TABLECOL_ASC = "new_tablecol ASC";

    public static final String NEW_TABLECOL_DESC = "new_tablecol DESC";

    public static final String NEW_TABLECOL1_ASC = "new_tablecol1 ASC";

    public static final String NEW_TABLECOL1_DESC = "new_tablecol1 DESC";

    public Integer getIdnewTable() {
        return idnewTable;
    }

    /**
     * @param idnewTable 
     */
    public void setIdnewTable(Integer idnewTable) {
        this.idnewTable = idnewTable;
    }

    public String getNewTablecol() {
        return newTablecol;
    }

    /**
     * @param newTablecol 
     */
    public void setNewTablecol(String newTablecol) {
        this.newTablecol = newTablecol == null ? null : newTablecol.trim();
    }

    public String getNewTablecol1() {
        return newTablecol1;
    }

    /**
     * @param newTablecol1 
     */
    public void setNewTablecol1(String newTablecol1) {
        this.newTablecol1 = newTablecol1 == null ? null : newTablecol1.trim();
    }
}