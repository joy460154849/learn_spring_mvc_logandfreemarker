package utils;

import java.util.List;


public class ListPage<T> {

	private Page page;
	private List<T> items;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	// 构造
	public ListPage(List<T> items, int intPage, int intPageSize,
			int intPageCount, int intRowCount) {
		this.items = items;

		page = new Page();
		page.setPage(intPage);
		page.setPageSize(intPageSize);
		page.setPageCount(intPageCount);
		page.setRowCount(intRowCount);

		if (intPage > 1) {
			page.setFirst(1);
			page.setPrevious(intPage - 1);
		}
		if (intPage < intPageCount) {
			page.setNext(intPage + 1);
			page.setLast(intPageCount);
		}
	}
	
//	public void setUrl(HttpServletRequest request) {
//		if (request.getQueryString() == null) {
//			setRequestUrl(request.getRequestURI());
//		} else {
//			setRequestUrl(request.getRequestURI() + "?"
//					+ request.getQueryString());
//		}
//	}
//
//	private void setRequestUrl(String RequestURL) {
//		if (RequestURL == null)
//			RequestURL = "";
//		String[] arr = RequestURL.split("\\?");
//		String strURI = arr[0];
//		String strQS = null;
//
//		if (arr.length > 1)
//			strQS = arr[1];
//
//		String strURL, strS1, strS2;
//
//		if (strQS == null) {
//			strURL = strURI + "?page=";
//		} else if (strQS.indexOf("page=") != -1) {
//			strS1 = strQS.substring(strQS.indexOf("page="));
//			if (strS1.indexOf("&") != -1) {
//				strS1 = strS1.substring(0, strS1.indexOf("&") + 1);
//			}
//			strS2 = strQS.replaceAll(strS1, "");
//			if ((strS2.length() > 1)
//					&& (strS2.substring(strS2.length() - 1).equals("&"))) {
//				strS2 = strS2.substring(0, strS2.length() - 1);
//			}
//			if (strS2.length() > 1) {
//				strS2 += "&";
//			}
//			strS2 += "page=";
//			strURL = strURI + "?" + strS2;
//		} else {
//			strURL = strURI + "?" + strQS + "&page=";
//		}
//		this.getPage().setUrlPrefix(strURL);
//
//	}
	
	
}
