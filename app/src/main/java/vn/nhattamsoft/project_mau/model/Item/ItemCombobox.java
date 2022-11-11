package vn.nhattamsoft.project_mau.model.Item;

public class ItemCombobox {
    private String ID, Code, Value;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public ItemCombobox(String id, String code, String value) {
        ID = id;
        Code = code;
        Value = value;
    }
}
