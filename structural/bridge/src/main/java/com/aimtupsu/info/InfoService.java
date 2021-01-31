package com.aimtupsu.info;

import com.aimtupsu.model.Info;
import java.util.List;

public interface InfoService {

    List<Info> getBankInfos();
    Info getShopInfo();

}
