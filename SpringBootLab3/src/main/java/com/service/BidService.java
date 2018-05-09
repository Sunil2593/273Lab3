package com.service;
import com.entity.Bid;
import com.repository.BidRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;

    public JSONObject getListOfAllBids(int projectId){
        List<Bid> bids=bidRepository.findListOfAllBidsOnProject(projectId);
        JSONObject obj = new JSONObject();
        obj.put("bids", bids);
        return obj;
    }
}