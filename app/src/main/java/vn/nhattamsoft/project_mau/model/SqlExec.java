package vn.nhattamsoft.project_mau.model;

import java.util.List;

public class SqlExec {
    public String sql;
    public List<Param> data;

    public SqlExec(String sql, List<Param> params) {
        this.sql = sql;
        this.data = params;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<Param> getParams() {
        return data;
    }

    public void setParams(List<Param> params) {
        this.data = params;
    }
}
