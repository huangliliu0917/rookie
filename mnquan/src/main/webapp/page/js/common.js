/**
 * static.cms - v1.0.0  License By 
 * WEB小组 
 */
!function(t,e){"use strict";try{var i="xctj";t.xckj=i,t[i]=t[i]||function(){(t[i].list=t[i].list||new Array).push(arguments)},t[i].time=t[i].time||1*new Date;var a=e.createElement("script");a.type="text/javascript",a.src="https://tj.ffquan.com/satc.js?z=20180605",a.async=1;var o=e.getElementsByTagName("script")[0];o.parentNode.insertBefore(a,o)}catch(n){}}(window,document);var MtaH5={clickStat:function(){},pgv:function(){}};!function($wui){$wui.cache.version=$('meta[name="version"]').attr("version")||"1.1.0",jQuery.fn.isChildAndSelfOf=function(t){return this.closest(t).length>0};var $cmsApi={setMtaCookie:function(t,e){if(t=t||"MTA-USER-ID",e=e||365,this.getMtaCookie())return this.getMtaCookie();var i=e,a=new Date;a.setTime(a.getTime()+24*i*60*60*1e3),document.cookie=t+"="+escape(function(){for(var t="",e=0;e<4;e++)t+=parseInt(1e8*Math.random());return hex_md5(t)}())+";expires="+a.toGMTString()},getMtaCookie:function(t){if(this.getCookie("trace_id"))return this.getCookie("trace_id");t=t||"MTA-USER-ID";var e,i=new RegExp("(^| )"+t+"=([^;]*)(;|$)");return!!(e=document.cookie.match(i))&&unescape(e[2])},setCookie:function(t,e,i){var a=i,o=new Date;console.log(o.getTime()+24*a*60*60*1e3),o.setTime(o.getTime()+24*a*60*60*1e3),document.cookie=t+"="+escape(e)+";expires="+o.toGMTString()},getCookie:function(t){var e,i=new RegExp("(^| )"+t+"=([^;]*)(;|$)");return!!(e=document.cookie.match(i))&&unescape(e[2])},delCookie:function(t){var e=new Date;e.setTime(e.getTime()-1);var i=this.getCookie(t);null!=i&&(document.cookie=t+"="+i+";expires="+e.toGMTString())},copy:function(t,e){var i=function(){function t(t,i){return e(t)===i}function e(t){return i[Object.prototype.toString.call(t)]||"object"}var i={};return["Null","Undefined","Number","Boolean","String","Object","Function","Array","RegExp","Date"].forEach(function(t){i["[object "+t+"]"]=t.toLowerCase()}),{isType:t,getType:e}}();if(null===t||"object"!=typeof t)return t;var a,o,n,c=i.isType(t,"array")?[]:{};for(a in t)o=t[a],n=i.getType(o),!e||"array"!==n&&"object"!==n?c[a]=o:c[a]=this.copy(o);return c},localStorage:function(time){var Days=time||.5,exp=new Date;if(exp.setTime(exp.getTime()+24*Days*60*60*1e3),exp=exp.getTime(),window.localStorage)try{}catch(e){return layer.msg("亲，无痕模式无法使用此功能！"),!1}var ret={setLocalStorage:function(t,e){return window.localStorage.setItem("LOCAL_"+t,JSON.stringify({time:exp,data:e}))},getLocalStorage:function(key){return eval("("+window.localStorage.getItem("LOCAL_"+key)+")")},removeLocalStorage:function(t){return window.localStorage.removeItem("LOCAL_"+t)},removeLocalStorageAll:function(){for(var t in window.localStorage)"LOCAL"==t.split("_")[0]&&this.removeLocalStorage(t)}};for(var i in window.localStorage)if("LOCAL"==i.split("_")[0]){var item=eval("("+window.localStorage[i]+")");item.time-(new Date).getTime()<=0&&ret.removeLocalStorage(i)}return ret},loaditem:[],satc:function(){var tid="tid=xc-dtk-cms-"+document.getElementsByTagName("body")[0].getAttribute("data-appid"),instr="in="+document.getElementsByTagName("body")[0].getAttribute("data-in");null!=document.getElementsByTagName("body")[0].getAttribute("data-appid")&&xctj(tid,"at=pageview","ds=wap",instr);for(var pageR=window.location.href.split("r=").length>1?"r="+window.location.href.split("r=")[1].split("&")[0]:"noR",coutData=coutData||[],i=0;i<coutData.length;i++)coutData[i].page!=pageR&&"0"!=coutData[i].page||!function(s){for(var paramBoole=!0,a=0;a<coutData[s].is_param.split(",").length;a++){var paramKey=coutData[s].is_param.split(",")[a]+"=";if(""!=coutData[s].is_param.split(",")[a]&&window.location.href.split(paramKey).length<2)return paramBoole=!1,!1}if(0==paramBoole)return!1;var isData=""!=coutData[s].is_data&&""!=$(coutData[s].page_class).data(coutData[s].is_data)&&void 0!=$(coutData[s].page_class).data(coutData[s].is_data)?',"'+coutData[s].is_data+"="+$(coutData[s].page_class).data(coutData[s].is_data)+'"':"",xcStr='"'+tid+'","ds=wap","ec='+coutData[s].page_event+'","'+instr+'"'+isData;0==coutData[s].is_posting_events?$(coutData[s].page_class).on(coutData[s].page_event,function(){var eventName=1==coutData[s].is_num?',"ea='+coutData[s].event_name+"_"+($(this).index()+1)+'"':',"ea='+coutData[s].event_name+'"';eval("xctj("+xcStr+eventName+")")}):$("body").on(coutData[s].page_event,coutData[s].page_class,function(){var eventName=1==coutData[s].is_num?',"ea='+coutData[s].event_name+"_"+($(this).index()+1)+'"':',"ea='+coutData[s].event_name+'"';eval("xctj("+xcStr+eventName+")")})}(i);$("*[ui-utm]").unbind("click").click(function(t){xctj("tid=xc-dtk-cms-"+$(this).data("uid"),"at=crs","ds=wap","in="+$(this).data("in"),"ec=click","gid="+$(this).data("gid"),"ci="+$(this).data("ci"),"cn="+$(this).data("cn"))})},digitalAbbNumber:function(t){if(t<1e4)return t;var e=[],i=0;t=(t||0).toString().split("");for(var a=!1,o=t.length-1;o>=0;o--)i++,a&&e.unshift(t[o]),i%4||0==o||a||(e.unshift(t[o]),e.unshift("."),a=!0);return("0"!=e[2]?e.join(""):function(){var t="",i=!0;return $.each(e,function(e,a){"."!=a&&i&&(t+=a,i=!1)}),t}())+"万"},loadProgress:100,loadAnimation:function(t){var e=$('<div class="ui_load"><p></p></div><div class="ui_load_bg"></div>');0==$(".ui_load").length&&$("body").append(e);var i=t<50?3e3:t<80?800:200;return $(".ui_load").find("p").animate({width:t+"%"},i),t==this.loadProgress&&setTimeout(function(){$(".ui_load,.ui_load_bg").fadeOut("400",function(){$(this).remove()})},800),e},getTime:function(t){return this.ajax({url:"http://cmsstatic.dataoke.com/now"}).done(function(e){t(e.data.time)})},ajax:function(t,e){return t=$.extend(!0,{type:"GET",dataType:"JSON"},t),$.ajax(t).done(function(t){e?e(t):"undefined"!=typeof t.status&&t.msg&&1!=t.status&&"ok"!=t.msg&&""!=t.msg&&(40003==t.code?(layer.msg(t.msg),$cmsApi.delCookie("TOKEN"),window.location.href="?r=login/login&returnUrl="+encodeURIComponent(window.location.href)):40007==t.code?$cmsApi.delCookie("TOKEN"):layer.msg(t.msg))}).error(function(){console.log("请求失败地址："+t.url),layer.msg("服务器繁忙请稍后再试！"),$cmsApi.loadAnimation(100)})},setLoadItem:function(t,e){var i=0;for(var a in this.loaditem)i>15&&this.loaditem.splice(0,1),i++;this.loaditem.push({key:t,item:e});var o=new Date;if(localStorage)try{localStorage.setItem("LOCAL-STORAGE-ITEM",JSON.stringify({time:o.getTime(),data:this.loaditem}))}catch(n){}return this.loaditem[t]},getLoadItem:function(id){var ret,loaditem=this.loaditem;if(localStorage)try{var item=eval("("+localStorage.getItem("LOCAL-STORAGE-ITEM")+")"),time=new Date;loaditem=item?time.getTime()-item.time>1e5?this.loaditem:item.data:this.loaditem,this.loaditem=loaditem}catch(e){}for(var key in loaditem)loaditem[key].key==id&&(ret=loaditem[key].item);return ret},goodsListTpl:function(t,e,i){for(var a="",o=0;o<=t.length-1;o++)a=a+'<li class="col-12-6" >    <div class="cent">        <a '+function(){var e="";if(!t[o].tongji)return e;for(var i in t[o].tongji)e=e+"data-"+i+"='"+t[o].tongji[i]+"' ";return e+"ui-utm"}()+' style="height:'+$(window).width()/2+'px;" href="'+e+"&id="+t[o].id+'" class="img"><img class="lazy" ui-lazyload src="'+(i||$wui.cache.host)+'/web/images/rolling.gif" data-original="'+t[o].pic+'_310x310.jpg" alt=""></a>        <div class="mar">            <a href='+e+"&id="+t[o].id+'><h3 class="bt">'+t[o].d_title+'</h3></a>            <div class="row-s num">                <div class="col-12-6">'+(1==t[o].istmall?" 天猫价 ¥"+t[o].yuanjia:"淘宝价 ¥"+t[o].yuanjia)+'</div>                <div class="col-12-6 text-right">已售'+this.digitalAbbNumber(t[o].xiaoliang)+'</div>            </div>            <div class="row-s">                <div class="col-12-6 money">                    <span>券后价&nbsp;¥</span>'+this.accSub(t[o].yuanjia,t[o].quan_jine)+'                </div>                <div class="col-12-6">                    <span class="quan"><i>'+t[o].quan_jine+"元券</i></span>                </div>            </div>        </div>    </div></li>";return a},goodsListTplTwo:function(t,e,i){for(var a="",o=0;o<=t.length-1;o++)a=a+'<li class="row-s"><a href="'+e+"&id="+t[o].id+'" >    <p  class="img"><img ui-lazyload src="'+(i||$wui.cache.host)+'/web/images/rolling.gif" data-original="'+t[o].pic+'_310x310.jpg" alt=""></p>    <div class="cent">        <h3>'+t[o].d_title+'</h3>        <div class="num col-aaa ">            <span>'+(1==t[o].istmall?" 天猫价 ¥"+t[o].yuanjia:"淘宝价 ¥"+t[o].yuanjia)+'</span><span class="fr">已售'+this.digitalAbbNumber(t[o].xiaoliang)+'件</span>        </div>        <div class=" money col-money">        <p class="quan fr"><i>'+t[o].quan_jine+'元券</i></p>券后价 <span class=""><i>¥</i>'+this.accSub(t[o].yuanjia,t[o].quan_jine)+"</span>        </div>    </div></a></li>";return a},accSub:function(t,e){var i,a,o,n;try{i=t.toString().split(".")[1].length}catch(c){i=0}try{a=e.toString().split(".")[1].length}catch(c){a=0}return o=Math.pow(10,Math.max(i,a)),n=i>=a?i:a,((t*o-e*o)/o).toFixed(n)},accAdd:function(t,e){var i,a,o,n;try{i=t.toString().split(".")[1].length}catch(c){i=0}try{a=e.toString().split(".")[1].length}catch(c){a=0}if(n=Math.abs(i-a),o=Math.pow(10,Math.max(i,a)),n>0){var s=Math.pow(10,n);i>a?(t=Number(t.toString().replace(".","")),e=Number(e.toString().replace(".",""))*s):(t=Number(t.toString().replace(".",""))*s,e=Number(e.toString().replace(".","")))}else t=Number(t.toString().replace(".","")),e=Number(e.toString().replace(".",""));return(t+e)/o},accMul:function(t,e){var i=0,a=t.toString(),o=e.toString();try{i+=a.split(".")[1].length}catch(n){}try{i+=o.split(".")[1].length}catch(n){}return Number(a.replace(".",""))*Number(o.replace(".",""))/Math.pow(10,i)},accDiv:function(arg1,arg2){var t1=0,t2=0,r1,r2;try{t1=arg1.toString().split(".")[1].length}catch(e){}try{t2=arg2.toString().split(".")[1].length}catch(e){}with(window.Math)return r1=Number(arg1.toString().replace(".","")),r2=Number(arg2.toString().replace(".","")),r1/r2*pow(10,t2-t1)},scrolltop:function(){$("body").append('<a class="iconfont icon-shang scroll_top"></a>');var t=$(window).height(),e=$(".layout").css("paddingBottom");$(".scroll_top").css({bottom:e}),$(document).scroll(function(e){$(document).scrollTop()>t+t/2?$(".scroll_top").addClass("active"):$(".scroll_top").removeClass("active")}),$(".scroll_top").click(function(t){$("body,html").animate({scrollTop:0},400)})}};$wui.uses(["layer","swiper"]).directive("ui-up-app",function(){return{uses:["page/js/models-up-app.js"],scope:{location:"location"},link:function(t){var e=t.scope,i=t.element;$wui.modelsUpApp.init(e,i)}}}).directive("ui-hover",function(){return{scope:{list:"list"},link:function(t){var e=t.scope,i=t.element;$(i).find(e.list).hover(function(){$(i).find(e.list).removeClass("cur"),$(this).addClass("cur"),$(this).addClass("active")},function(){$(this).removeClass("active")})}}}).directive("ui-show",function(){return{scope:{parents:"parents","class":"css",active:"active"},link:function(t){var e=t.scope,i=t.element,a=function(t){return e["class"]?$(e["class"]):$(t).parents(e.parents||"div")};$(i).unbind("click").on("click",function(){var t=this;0!=e.active?$(this).toggleClass("active"):$(this).removeClass("active"),$(document).unbind("click").on("click",function(){$(event.target).isChildAndSelfOf(t,a(t))||($(t).removeClass("active"),a(t).removeClass("active"))}),a(this).toggleClass("active")})}}}).directive("ui-share-code",function(){return{uses:["../page/js/goods-share-copy.js","../clipboard.min.js"],scope:{item:"=item"},link:function(t){var e=t.scope,i=t.element;$(i).unbind("click").on("click",function(){$wui.goodsShareCode.getCodeShow(e.item)})}}}).directive("ui-share-img",function(){return{uses:["../page/js/goods-share-copy.js","../clipboard.min.js"],scope:{img:"img"},link:function(t){var e=t.scope,i=t.element;$(i).unbind("click").on("click",function(){$wui.goodsShareCode.getCanvasImage(e.img)})}}}).directive("ui-code-shop",function(){return{uses:["../page/js/goods-share-copy.js","../clipboard.min.js"],scope:{item:"=item"},link:function(t){var e=t.scope,i=t.element;$(i).unbind("click").on("click",function(){$.ajax({url:"?r=p/savemoney",type:"post",data:{token:$cmsApi.getCookie("TOKEN"),money:$(".getGoodsLink").data("money"),id:$(".getGoodsLink").data("id")}}),$wui.goodsShareCode.getCodeShopping(e.item)})}}}).directive("ui-weixin-open",function(){return{template:"<div class='weixin-msg'></div>",scope:{},link:function(t){var e=(t.scope,t.element),i=$(t.template);$(e).unbind("click").on("click",function(){$("body").append(i),i.unbind("click").on("click",function(){$(this).remove()})})}}}).directive("ui-lazyload",function(){return{uses:["../page/js/lazyload.js"],scope:{},link:function(t){var e=(t.scope,t.element);$(e).lazyload({effect:"fadeIn"})}}}).directive("ui-classify",function(){return{uses:["page/js/models-goods-classify.js","plugin/swiper/js/swiper.js"],addcss:["plugin/swiper/swiper.css"],scope:{url:"url",fixed:"=fixed",item:"=item",callback:"=callback",ready:"=ready",active:"active"},link:function(t){var e=t.scope,i=t.element,a=setInterval(function(){$wui.modelsGoodsClassify&&($wui.modelsGoodsClassify.init(e,i),clearInterval(a))},300)}}}).directive("ui-back",function(){return{scope:{},link:function(t){var e=(t.scope,t.element);$(e).unbind("click").on("click",function(){if(!$(this).attr("href")){if(window.history.length>1)return window.history.back(-1),!1;window.location.href=window.location.origin+window.location.pathname+"?r=index/wap"}})}}}).directive("ui-open-taobao",function(){return{scope:{},link:function(t){var e=(t.scope,t.element),i=function(t){var e=t.replace("http://","").replace("https://",""),i=document.createElement("iframe");i.src="taobao://"+e,i.style.display="none",document.body.appendChild(i),window.location=t},a=function(t){var e=t.replace("http://","").replace("https://",""),i="taobao://"+e;window.location=i,window.setTimeout(function(){window.location=t},3e3)},o=function(){var t=navigator.userAgent.toLowerCase();return"micromessenger"==t.match(/MicroMessenger/i)};$(e).unbind("click").on("click",function(t){t.preventDefault(),MtaH5.clickStat("dovoucher",{vamount:$(".goods_quan .row .money p span").html(),uid:$cmsApi.getMtaCookie(),gid:window.location.href.split("&")[1].split("=")[1],domainid:window.location.hostname.replace("www.","")});var e=$(this).attr("href");if($.ajax({url:"?r=p/savemoney",type:"post",data:{token:$cmsApi.getCookie("TOKEN"),money:$(this).data("money"),id:$(this).data("id")}}),!o()){$("body").html("<center style='margin-top: 10px;'>唤醒手机淘宝中...</center>");var n=navigator.userAgent.toLowerCase();"iphone os 9"==n.match(/iphone os 9/i)?a(e):i(e)}})}}}).directive("ui-home-content",function(){return{uses:["page/js/models-home.js"],scope:{item:"=item"},link:function(t){var e=t.scope,i=t.element;return!$(i).attr("isLoad")&&($(i).attr("isLoad",!0),MtaH5.clickStat("showPage",{uid:$cmsApi.getMtaCookie(),name:"首页",siteid:standId,domainid:window.location.hostname.replace("www.",""),time:((new Date).getHours()<10?"0"+(new Date).getHours():(new Date).getHours())+":"+((new Date).getMinutes()<10?"0"+(new Date).getMinutes():(new Date).getMinutes())}),void $wui.homeModels.init(e,i))}}}).directive("ui-goods-list-tow",function(){return{uses:["http://"+$wui.cache.host+"wap_new/common/models/models-goods-list-tow.js"],scope:{page:"=page",url:"url"},link:function(t){var e=t.scope,i=t.element;$wui.modelsGoodsListTow.init(e,i)}}}).directive("ui-login",function(){return{uses:["page/js/login.js"],scope:{page:"type",url:"url",returnUrl:"return-url","switch":"switch",mtaCase:"mta-case"},link:function(t){var e=t.scope,i=t.element;$wui.modelsLogin.init(e,i)}}}).directive("ui-exit-login",function(){return{scope:{},link:function(t){var e=(t.scope,t.element),i=$cmsApi.getCookie("TOKEN"),a=layer.load();i||(window.location.href="?r=login/login&returnUrl="+window.location.href),layer.close(a),$(e).unbind("click").on("click",function(t){t.preventDefault(),wui.layer.confirm("是否需要退出？",{icon:3,title:"提示",btn:["是","否"]},function(t){wui.layer.load(),$cmsApi.ajax({url:"?r=login/destroy",data:{token:i}}).done(function(){wui.layer.closeAll(),$cmsApi.delCookie("TOKEN"),window.location.replace("?r=login/login")}),layer.close(t)})})}}}).directive("ui-footprint",function(){return{uses:["../page/js/lazyload.js","page/js/footprint.js"],scope:{item:"=item",type:"type",openUrl:"open-url"},link:function(t){var e=t.scope,i=t.element;$wui.modelsFootprint.init(e,i)}}}).directive("ui-collection",function(){return{uses:["../page/js/lazyload.js","../page/js/collection.js"],scope:{item:"=item",type:"type",openUrl:"open-url"},link:function(t){var e=t.scope,i=t.element;$wui.modelsCollection.init(e,i)}}}).directive("ui-add-collection",function(){return{scope:{id:"id"},link:function(t){var e=t.scope,i=t.element,a=$cmsApi.getCookie("TOKEN");$cmsApi.ajax({url:"?r=user/addcheck",type:"POST",data:{id:e.id,token:a}}).done(function(t){t.status?$(i).addClass("active").unbind("click").on("click",function(t){t.preventDefault(),wui.layer.msg("该商品已经收藏！")}):o()});var o=function(){var t=!1;$(i).unbind("click").on("click",function(o){return o.preventDefault(),!t&&(t=!0,void $cmsApi.ajax({url:"?r=user/add",type:"POST",data:{id:e.id,token:a}}).done(function(e){t=!1,1==e.status&&($(i).addClass("active"),wui.layer.msg("添加收藏成功！"))}).error(function(){t=!1}))})}}}}).directive("ui-mta-modular",function(){return{scope:{type:"type",mtaName:"mta_name"},link:function(t){var e=t.scope,i=t.element;return!$(i).attr("isLoad")&&($(i).attr("isLoad",!0),MtaH5.clickStat("showModule",{uid:$cmsApi.getMtaCookie(),name:e.mtaName}),void $(i).find("*[data-mold]").unbind("click").on("click",function(t){MtaH5.clickStat("clickModule",{uid:$cmsApi.getMtaCookie(),name:e.mtaName,area:$(this).data("el"),mold:$(this).data("mold"),addr:$(this).data("addr")})}))}}}).directive("ui-dragload",function(){return{uses:["../page/js/lazyload.js"],scope:{callback:"~callback"},link:function(t){function e(t){$(window).scroll(function(){var e=$(t).offset().top+.8*$(t).height();return!o&&void($(window).scrollTop()+$(window).height()>=e&&(o=!o,a.callback(t,i)))})}function i(){o=!o}if($(t.element).attr("isLoad"))return!1;$(t.element).attr("isLoad",!0);var a=t.scope;e($(t.element));var o=!1}}}),$(window).load(function(){$cmsApi.setMtaCookie()});var setLayer=setInterval(function(){wui.layer&&(wui.layer.msg=function(t){$(".icon_msg").remove();var e=$('<div class="icon_msg"><span>'+t+"</span></div>");$("body").append(e),e.addClass("active"),setTimeout(function(){e.addClass("up").removeClass("active"),setTimeout(function(){e.remove()},400)},2e3)},clearInterval(setLayer))},300);$cmsApi.satc(),$cmsApi.scrolltop(),window.$cmsApi=$cmsApi}(wui);