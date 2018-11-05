package com.perye.example.domain;

        import lombok.Data;

/**
 * @author: Perye
 * @create: 2018-10-23 21:11
 **/
@Data
public class Msg {
    private String title;
    private String content;
    private String etraInfo;

    public Msg(String title, String content, String etraInfo) {
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }
}
