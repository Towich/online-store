package com.example.firstpractice.data.api.vk;

public class ResponseWallResponse {
    private int likes;
    private int reposts;

    public ResponseWallResponse(int likes, int reposts) {
        this.likes = likes;
        this.reposts = reposts;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getReposts() {
        return reposts;
    }

    public void setReposts(int reposts) {
        this.reposts = reposts;
    }
}
