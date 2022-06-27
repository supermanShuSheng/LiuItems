package com.shusheng.filter;

import com.netflix.zuul.ZuulFilter;


//@Component
public class LoginFilter extends ZuulFilter {
	/**
	 * 返回值可取： - pre：在请求路由之前执行 - route：在请求路由时调用 - post：请求路由之后调用，
	 * 也就是在route和error过滤器之后调用 - error：处理请求发生错误时调用
	 *
	 * @return
	 */

	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 返回值是int，会根据返回值进行定义过滤器的执行顺序，值越小优先级越大
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

	/**
	 * 当前过滤器是否被执行，true则执行，false不执行
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤信息功能
	 * @return
	 */
	@Override
	public Object run(){
//		SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
//		System.out.println("用户"+ tokenInfo.getLoginId() +"进行访问！所携带token值为"+tokenInfo.getTokenValue());
//		// 要进行放行的Url
//		List<String> urlPath = Arrays.asList("/user/checkUser","/docs/getImgOne");
//
//		RequestContext ctx = RequestContext.getCurrentContext();
//		ctx.getResponse().setContentType("text/html;charset=UTF-8");
//		HttpServletRequest request = ctx.getRequest();
//		// 获取请求路径端口后的路径
//		String url = request.getServletPath();
//		// 验证
//		try {
//			if (stringMath(url, urlPath)){
//				System.out.println("过滤URL  放行！！");
//				return null;
//			}
//			// 校验是否登录  如果未登录 则抛出异常
//			StpUtil.checkLogin();
//		}catch (NotLoginException e){
//			System.out.println("错误信息："+e.getMessage());
//			JSONObject result = new JSONObject();
//			result.put("codes", 750);
//			result.put("msg", e.getMessage());
//			//过滤该请求，不对其进行路由
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseBody(JSONObject.toJSONString(result));
//
//			return false;
//		}catch (Exception e){
//			System.out.println("e = " + e);
//			JSONObject result = new JSONObject();
//			result.put("codes", 750);
//			result.put("msg", "网关异常！");
//			//过滤该请求，不对其进行路由
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseBody(JSONObject.toJSONString(result));
//
//			return false;
//		}
//		return null;
		return true;
	}

//	/**
//	 * 字符串匹配
//	 * @param url
//	 * @param urlPath
//	 * @return
//	 */
//	private boolean stringMath(String url, List<String> urlPath) {
//		for (String path : urlPath) {
//			if (path.equals(url)){
//				return true;
//			}
//		}
//		return false;
//	}
}
