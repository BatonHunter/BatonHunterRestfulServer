package org.batonhunter.server.restful.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ianchiu on 2015/7/11.
 */
public class Treasure {
    private TreasureType treasure;
    private String email;

    public TreasureType getTreasure() {
        return treasure;
    }

    public String getEmail() {
        return email;
    }

    public enum TreasureType{
        @SerializedName("slot")
        SLOT("slot", 10, 100),
        @SerializedName("smallmonster")
        SMALLMONSTER("smallmonster", 50, 50),
        @SerializedName("bigmonster")
        BIGMONSTER("bigmonster", 100, 120),
        @SerializedName("boss")
        BOSS("boss", 1000, 1000);

        private String type;
        private int money;
        private int exp;
        private TreasureType(String type, int money, int exp){
            this.type = type;
            this.money = money;
            this.exp = exp;
        }
        public int getMoney() {
            return money;
        }
        public int getExp() {
            return exp;
        }
    }
}
