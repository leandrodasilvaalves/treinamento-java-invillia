package br.com.invillia.dto;

public class HashtagDTO {

    private Long id;

    private String hashtag;

    public HashtagDTO() {
    }

    public HashtagDTO(String hashtag) {
        this.hashtag = hashtag;
    }

    public HashtagDTO(String hashtag, Long id) {
        this.hashtag = hashtag;
        this.id = id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
