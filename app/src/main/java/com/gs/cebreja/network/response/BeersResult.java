package com.gs.cebreja.network.response;

import java.util.List;

public class BeersResult {

    private final List<BeersResponse> results;

    public BeersResult(List<BeersResponse> results) {
        this.results = results;
    }

    public List<BeersResponse> getResults() {
        return results;
    }
}
