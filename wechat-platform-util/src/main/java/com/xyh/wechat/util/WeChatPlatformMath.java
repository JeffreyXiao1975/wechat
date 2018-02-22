package com.xyh.wechat.util;

public final class WeChatPlatformMath {
	public static long GetTotalPageNumber(long totalRecordNumber, int pageSize) {
		long totalPageNumber = 0;
		long lpageSize = (new Long(pageSize)).longValue();
		
		if (totalRecordNumber > 0) {
			if (totalRecordNumber%lpageSize == 0) {
				totalPageNumber = totalRecordNumber / lpageSize;
			} else {
				totalPageNumber = (totalRecordNumber / lpageSize) + 1;
			}
		} 
		
		return totalPageNumber;
	}
}
