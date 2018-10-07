<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/page/commons.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-dns-prefetch-control" content="on">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta content="telephone=no" name="format-detection">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>居家日用_淘券宝</title>
    <meta name="keywords" content="9.9包邮，白菜价，天天特价，优惠卷,淘券宝">
    <meta name="description" content="9.9包邮，白菜价，天天特价">
    <script src="${contextPath}/page/js/jquery.min.js" type="text/javascript"></script>
    <link href="${contextPath}/page/js/wap_common.css" rel="stylesheet">
    <link href="${contextPath}/page/js/wapcat.css" rel="stylesheet"/>
</head>
<body data-appid="489217" data-in="1" style="">
<div class="main-title clearfix theme-bg-color-1">
    <a href="javascript:void(0)"  onclick="window.location.href=document.referrer;" class="main-back"></a>
    <div class="menu-detail">
        <span>${categoryName}</span>
    </div>
    <a class="mui-action-menu main-more" href="javascript:void(0)" id="cat-action-menu"></a>
</div>
<nav id="detail-top-menu">
    <div class="arrow"></div>
    <div class="mask" id="menu-mask2"></div>
    <div class="detail-menu-content">
        <ul class="main-detail">
            <li>
                <a href="/app"><i class="iconfontv2 icon-detail_home"></i>首页</a>
            </li>
            <li>
                <a href="/index.php?r=index/classify"><i class="iconfontv2 icon-detail_search"></i>搜索</a>
            </li>
        </ul>
    </div>
</nav>
<div class="icon_nav_tab_bg" style="height: 48px;"></div>
<div class="order-nav order-nav-cat" style="position: relative; top: 0px; margin-top: 0px;">
    <ul>
        <li class="">
            <span><a data-sort="t" class="" href="/index.php?r=index/cat&amp;px=t&amp;cid=6&amp;u=489217">人气</a></span>
        </li>
        <li class="theme-border-bottom-color-1 cur">
            <span><a data-sort="latest" href="/index.php?r=index/cat&amp;px=latest&amp;cid=6&amp;u=489217" class="theme-color-1">最新</a></span>
        </li>
        <li class="">
            <span><a data-sort="sell" href="/index.php?r=index/cat&amp;px=sell&amp;cid=6&amp;u=489217">销量</a></span>
        </li>
        <li class="">
            <span>
                <a data-sort="price" href="/index.php?r=index/cat&amp;px=price&amp;cid=6&amp;u=489217">价格

                <!--                    ico-up 升序   ico-down降序-->
                </a>
                <img src="http://localhost:8080/page/img/sx.png" class="price-ico"></img>
            </span>
        </li>
    </ul>
</div>

<div class="order-nav-bg ov_h " style="height: 0"></div>

<style>
    .scrollable{
        bottom: 0;
        left: 0;
        right: 0;
        overflow-y: scroll;
        -webkit-overflow-scrolling: touch;
        -webkit-box-flex: 1;
        background-color: #faf5f6;
    }
</style>
<div class="scrollable">
    <div class="goods-list" data-page="2" style="padding-top: 0;">
        <div id="classify_product_div" class="lazy1">
            <%--<div class="goods-item">
                <a data-gid="16537009" href="/index.php?r=p/d&amp;id=16537009&amp;u=489217" class="img">
                    <span class="coupon-wrapper  theme-bg-color-1">券 <i>￥</i><b>10</b></span>            <span class="today-wrapper"><b>NEW</b></span>                        <img class="lazy" src="https://img.alicdn.com/bao/uploaded/TB15uJ4hcjI8KJjSsppwu0byVXa.png_310x310.jpg" data-original="https://img.alicdn.com/bao/uploaded/TB15uJ4hcjI8KJjSsppwu0byVXa.png_310x310.jpg" alt="" style="background: rgb(245, 245, 245); display: inline;">
                </a>
                <a data-gid="16537009" href="/index.php?r=p/d&amp;id=16537009&amp;u=489217" class="title">
                    <div class="text">【千选】精准体重秤电子称</div>
                </a>
                <div class="price-wrapper">
                    <span class="price">￥<span>19.8</span></span><span class="text">券后</span><div class="sold-wrapper"><span class="text">销量</span><span class="sold-num">296932</span></div>        </div>
            </div>--%>
        </div>
    </div>
    <div class="pullup-goods">
        <div class="label">点击加载更多</div>
        <%--<div class="label">商品加载中...</div>--%>
    </div>
</div>
<div class="toTop" style="bottom: 0px; display: none;"></div>
<div style="display: none;">
</div>
<div id="return-top">
    <a>
        <img src="http://localhost:8080/page/img/top.png">
    </a>
</div>
<script src="http://localhost:8080/page/js/swiper-4.4.1.min.js" type="text/javascript"></script>
<script>
    var pageNo = 1;
    var domain = "http://"+window.location.host;

    $(function(){
        //获取商品列表
        get_list();
        //加载页面元素
        function get_list(){
            $.ajax({
                url:""+"/app/index/getProductList.do",
                async:false,
                data: {'pageNo':pageNo},
                dataType:'json',
                type:"post",
                success:function(data){
                    //console.log(data);
                    var arrLen = data.length;
                    if(arrLen > 0){
                        var classifyProductHtml = '';
                        $.each(data,function(index,item){
                            classifyProductHtml+='<div class="goods-item"><a data-gid="16537009" href="'+domain+'/app/detail/skipProductDetail.do?numIid='+item.numIid+'" class="img">' +
                                '<span class="coupon-wrapper  theme-bg-color-1">券 <i>￥</i><b>'+item.couponAmount+'</b></span>' +
                                '<span class="today-wrapper"><b>NEW</b></span>' +
                                '<img class="lazy" src='+item.pictUrl+' style="background: rgb(245, 245, 245); display: inline;"></a>' +
                                '<a data-gid="16537009" href="/index.php?r=p/d&amp;id=16537009&amp;u=489217" class="title">' +
                                '<div class="text">【千选】'+item.shortTitle+'</div></a>' +
                                '<div class="price-wrapper"><span class="price">￥<span>'+accSub(item.zkFinalPrice,item.couponAmount)+'</span></span>' +
                                '<span class="text">券后</span><div class="sold-wrapper"><span class="text">销量</span>' +
                                '<span class="sold-num">'+item.volume+'</span></div></div></div>';
                        });
                        $("#classify_product_div").after(classifyProductHtml);
                        pageNo++;
                    }
                }
            });
        }

        //减法避免丢失精度
        function accSub(arg1, arg2) {
            var r1, r2, m, n;
            try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
            try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
            m = Math.pow(10, Math.max(r1, r2));
            n = (r1 >= r2) ? r1 : r2;
            return ((arg1 * m - arg2 * m) / m).toFixed(n);
        }
        //加法避免丢失精度
        function accAdd(arg1, arg2) {
            var r1, r2, m;
            try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
            try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
            m = Math.pow(10, Math.max(r1, r2))
            return (arg1 * m + arg2 * m) / m
        }

        $('.pullup-goods').click(function(){
            $('.label').empty();
            $('.label').append('商品加载中...');
            get_list();
            $('.label').empty();
            $('.label').append('点击加载更多')
        })

        $("#cat-action-menu").click(function () {
            var tabByStyle = $("#detail-top-menu").attr("class");
            if(null != tabByStyle && ""!= tabByStyle){
                document.getElementById("detail-top-menu").className = "";
            }else {
                document.getElementById("detail-top-menu").className = "show";
            }
        });

        //返回顶部按钮控制
        $('#return-top').hide();
        $(function(){
            $(window).scroll(function(){
                if($(window).scrollTop()>300){
                    $('#return-top').fadeIn(300);
                }
                else{$('#return-top').fadeOut(200);}
            });
            $('#return-top').click(function(){
                $('body,html').animate({scrollTop:0},300);
                return false;
            })
        })
    })
</script>
</body>
</html>