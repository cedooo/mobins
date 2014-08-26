package cn.com.dhcc.cgn.mobins.inspection.client;

public abstract class WSClient {
	/**
	 * 发送事件
	 * @param event
	 * @return
	 */
	public abstract String postAlarm(Event event);
}
