package com.ceres.api.domain.stream;

/**
 * 成交推送，状态推送的websocket信息
 *
 * @author LMT
 */
public class EntrustNotice {

    /** 交易所名称 */
    private String exchange;

    /** 交易对 */
    private String symbol;

    /** 委托单号 */
    private String system_oid;

    /** 客户端单号 */
    private String client_oid;

    /** 成交均价 */
    private String average_dealt_price;

    /** 委托时间 */
    private String entrust_time;

    /** 委托状态 */
    private String status;

    /** 委托方向 */
    private String entrust_bs;

    /** 价格类型 */
    private String price_type;

    /** 杠杆倍数 */
    private String lever;

    /** 委托价格 */
    private String entrust_price;

    /** 委托数量 */
    private String entrust_amount;

    /** 本单累计成交数量 */
    private String dealt_amount;

    /**
     * 最新成交时间
     */
    private String dealt_time;

    /**
     * 交易类型
     */
    private String trade_type;

    /**
     * 保证金模式
     */
    private String margin_mode;

    /**
     * 账户编码
     */
    private long asset_code;

    /**
     * 程序单编码
     */
    private String program_oid;

    /** 通知类型 1: 状态变更通知  2: 持仓变化通知 */
    private int message_type;
    /**
     * 最新一次成交数量 即本次成交的数量 仅在成交下有值 其他状态推送是 "0"
     */
    private String last_fill_amount;

    /**
     * 最新一次成交价格 即本次成交的价格 仅在成交下有值 其他状态推送是 "0"
     */
    private String last_fill_price;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSystem_oid() {
        return system_oid;
    }

    public void setSystem_oid(String system_oid) {
        this.system_oid = system_oid;
    }

    public String getClient_oid() {
        return client_oid;
    }

    public void setClient_oid(String client_oid) {
        this.client_oid = client_oid;
    }

    public String getAverage_dealt_price() {
        return average_dealt_price;
    }

    public void setAverage_dealt_price(String average_dealt_price) {
        this.average_dealt_price = average_dealt_price;
    }

    public String getEntrust_time() {
        return entrust_time;
    }

    public void setEntrust_time(String entrust_time) {
        this.entrust_time = entrust_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntrust_bs() {
        return entrust_bs;
    }

    public void setEntrust_bs(String entrust_bs) {
        this.entrust_bs = entrust_bs;
    }

    public String getPrice_type() {
        return price_type;
    }

    public void setPrice_type(String price_type) {
        this.price_type = price_type;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public String getEntrust_price() {
        return entrust_price;
    }

    public void setEntrust_price(String entrust_price) {
        this.entrust_price = entrust_price;
    }

    public String getEntrust_amount() {
        return entrust_amount;
    }

    public void setEntrust_amount(String entrust_amount) {
        this.entrust_amount = entrust_amount;
    }

    public String getDealt_amount() {
        return dealt_amount;
    }

    public void setDealt_amount(String dealt_amount) {
        this.dealt_amount = dealt_amount;
    }

    public String getDealt_time() {
        return dealt_time;
    }

    public void setDealt_time(String dealt_time) {
        this.dealt_time = dealt_time;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getMargin_mode() {
        return margin_mode;
    }

    public void setMargin_mode(String margin_mode) {
        this.margin_mode = margin_mode;
    }

    public long getAsset_code() {
        return asset_code;
    }

    public void setAsset_code(long asset_code) {
        this.asset_code = asset_code;
    }

    public String getProgram_oid() {
        return program_oid;
    }

    public void setProgram_oid(String program_oid) {
        this.program_oid = program_oid;
    }

    public int getMessage_type() {
        return message_type;
    }

    public void setMessage_type(int message_type) {
        this.message_type = message_type;
    }

    public String getLast_fill_amount() {
        return last_fill_amount;
    }

    public void setLast_fill_amount(String last_fill_amount) {
        this.last_fill_amount = last_fill_amount;
    }

    public String getLast_fill_price() {
        return last_fill_price;
    }

    public void setLast_fill_price(String last_fill_price) {
        this.last_fill_price = last_fill_price;
    }

    @Override
    public String toString() {
        return "EntrustNotice{" +
                "exchange='" + exchange + '\'' +
                ", symbol='" + symbol + '\'' +
                ", system_oid='" + system_oid + '\'' +
                ", client_oid='" + client_oid + '\'' +
                ", average_dealt_price='" + average_dealt_price + '\'' +
                ", entrust_time='" + entrust_time + '\'' +
                ", status='" + status + '\'' +
                ", entrust_bs='" + entrust_bs + '\'' +
                ", price_type='" + price_type + '\'' +
                ", lever='" + lever + '\'' +
                ", entrust_price='" + entrust_price + '\'' +
                ", entrust_amount='" + entrust_amount + '\'' +
                ", dealt_amount='" + dealt_amount + '\'' +
                ", dealt_time='" + dealt_time + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", margin_mode='" + margin_mode + '\'' +
                ", asset_code=" + asset_code +
                ", program_oid='" + program_oid + '\'' +
                ", message_type=" + message_type +
                ", last_fill_amount='" + last_fill_amount + '\'' +
                ", last_fill_price='" + last_fill_price + '\'' +
                '}';
    }
}
