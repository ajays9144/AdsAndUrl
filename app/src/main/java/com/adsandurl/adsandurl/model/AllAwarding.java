package com.adsandurl.adsandurl.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllAwarding {
    @SerializedName("giver_coin_reward")
    @Expose
    private String giverCoinReward;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("is_new")
    @Expose
    private Boolean isNew;
    @SerializedName("days_of_drip_extension")
    @Expose
    private Integer daysOfDripExtension;
    @SerializedName("coin_price")
    @Expose
    private Integer coinPrice;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("penny_donate")
    @Expose
    private float pennyDonate;
    @SerializedName("coin_reward")
    @Expose
    private Integer coinReward;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("days_of_premium")
    @Expose
    private Integer daysOfPremium;
    @SerializedName("icon_height")
    @Expose
    private Integer iconHeight;
    @SerializedName("resized_icons")
    @Expose
    private List<ResizedIcon> resizedIcons = null;
    @SerializedName("icon_width")
    @Expose
    private Integer iconWidth;
    @SerializedName("start_date")
    @Expose
    private long startDate;
    @SerializedName("is_enabled")
    @Expose
    private Boolean isEnabled;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("end_date")
    @Expose
    private long endDate;
    @SerializedName("subreddit_coin_reward")
    @Expose
    private Integer subredditCoinReward;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icon_format")
    @Expose
    private String iconFormat;
    @SerializedName("award_sub_type")
    @Expose
    private String awardSubType;
    @SerializedName("penny_price")
    @Expose
    private float pennyPrice;
    @SerializedName("award_type")
    @Expose
    private String awardType;

    public String getGiverCoinReward() {
        return giverCoinReward;
    }

    public void setGiverCoinReward(String giverCoinReward) {
        this.giverCoinReward = giverCoinReward;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Integer getDaysOfDripExtension() {
        return daysOfDripExtension;
    }

    public void setDaysOfDripExtension(Integer daysOfDripExtension) {
        this.daysOfDripExtension = daysOfDripExtension;
    }

    public Integer getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(Integer coinPrice) {
        this.coinPrice = coinPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPennyDonate() {
        return pennyDonate;
    }

    public void setPennyDonate(float pennyDonate) {
        this.pennyDonate = pennyDonate;
    }

    public Integer getCoinReward() {
        return coinReward;
    }

    public void setCoinReward(Integer coinReward) {
        this.coinReward = coinReward;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getDaysOfPremium() {
        return daysOfPremium;
    }

    public void setDaysOfPremium(Integer daysOfPremium) {
        this.daysOfPremium = daysOfPremium;
    }

    public Integer getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(Integer iconHeight) {
        this.iconHeight = iconHeight;
    }

    public List<ResizedIcon> getResizedIcons() {
        return resizedIcons;
    }

    public void setResizedIcons(List<ResizedIcon> resizedIcons) {
        this.resizedIcons = resizedIcons;
    }

    public Integer getIconWidth() {
        return iconWidth;
    }

    public void setIconWidth(Integer iconWidth) {
        this.iconWidth = iconWidth;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public Integer getSubredditCoinReward() {
        return subredditCoinReward;
    }

    public void setSubredditCoinReward(Integer subredditCoinReward) {
        this.subredditCoinReward = subredditCoinReward;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconFormat() {
        return iconFormat;
    }

    public void setIconFormat(String iconFormat) {
        this.iconFormat = iconFormat;
    }

    public String getAwardSubType() {
        return awardSubType;
    }

    public void setAwardSubType(String awardSubType) {
        this.awardSubType = awardSubType;
    }

    public float getPennyPrice() {
        return pennyPrice;
    }

    public void setPennyPrice(float pennyPrice) {
        this.pennyPrice = pennyPrice;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }
}
