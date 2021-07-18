package com.aimtupsu.info;

import com.aimtupsu.model.Info;
import java.util.List;

public interface InfoService {

    /**
     * Получает информацию о всех банках.
     *
     * @return информация о всех банках.
     */
    List<Info> getBankInfos();

}
