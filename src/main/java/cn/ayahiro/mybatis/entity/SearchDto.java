package cn.ayahiro.mybatis.entity;

import java.util.List;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/18
 */
public class SearchDto {
    private String type;
    private List<String> index;

    public SearchDto(String type, List<String> index) {
        this.type = type;
        this.index = index;
    }

    public SearchDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getIndex() {
        return index;
    }

    public void setIndex(List<String> index) {
        this.index = index;
    }
}
