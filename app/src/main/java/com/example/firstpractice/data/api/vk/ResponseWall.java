package com.example.firstpractice.data.api.vk;

public class ResponseWall {
    private ResponseWallResponse response;

    public ResponseWall(ResponseWallResponse response) {
        this.response = response;
    }

    public ResponseWallResponse getResponseVK() {
        return response;
    }

    public void setResponseVK(ResponseWallResponse response) {
        this.response = response;
    }
}
