<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta http-equiv="x-dns-prefetch-control" content="on">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta content="telephone=no" name="format-detection">
    <meta name="version" version="201809201019">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>搜券宝-天天为您挑选精品，9.9包邮，白菜价，天天特价</title>
    <meta name="keywords" content="9.9包邮，白菜价，天天特价，优惠卷,搜券宝">
    <meta name="description" content="9.9包邮，白菜价，天天特价">
    <meta itemprop="image" content="_50x50.jpg">
    <link rel="stylesheet" href="../page/js/common.css">
    <link rel="stylesheet" type="text/css" href="../page/js/index.css" charset="utf-8">
    <link rel="stylesheet" href="../page/js/main.css">
    <link rel="stylesheet" href="../page/js/swiper-4.4.1.min.css">
    <script src="../page/js/jquery.js" type="text/javascript"></script>
    <script src="../page/js/swiper-4.4.1.min.js" type="text/javascript"></script>
    <style>
        #return-top{position:fixed;bottom:10%;right:50px; width:60px;height:60px;text-align:center;display:none;}
        #return-top a{text-decoration:none;}
    </style>
<body data-appid="489217" data-in="1">

<div class="header_pr header_red transition" style="transform: translateY(0px) translateX(0px);">
    <header class="icon_header">
        <a></a>
        <div class="search">
            <a href="/index.php?r=index/classify">
                <div class="icon_search">
                    <i class="iconfont icon-detail_search"></i>输入您需要的商品名称
                </div>
            </a>
        </div>
        <a href="/index.php?r=user/footprint" class="iconfont icon-zuji"></a>
    </header>
</div>
<div class="header_bg"></div>

<div class="ui_bot_tab" data-mta_name="首页-底部导航" ui-mta-modular="">
    <div class="row-s">
        <a data-mold="1" data-el="1" data-addr="/index.php?r=index/wap" href="/index.php?r=index/wap" class="col-10-2 ">
            <i class="iconfont"><img src="https://img.alicdn.com/imgextra/i4/2053469401/TB24KbjnZj_B1NjSZFHXXaDWpXa-2053469401.png"></i>
            <span style="color: rgb(253, 87, 92);">首页</span>
        </a>

        <a data-mold="1" data-el="2" data-addr="/index.php?r=nine/wap" href="/index.php?r=nine/wap" class="col-10-2 ">
            <em class="num" style="background-image: -webkit-gradient(linear, left 20, right 0, from(#DC143C), to(	#FF0000));-webkit-background-clip: text;-webkit-text-fill-color: transparent;">新</em>
            <i class="iconfont"><img src="https://img.alicdn.com/imgextra/i4/2053469401/TB23GLTn77mBKNjSZFyXXbydFXa-2053469401.png"></i>
            <span style="color: rgb(102, 102, 102);">9.9包邮</span>
        </a>

        <a data-mold="1" data-el="3" data-addr="/index.php?r=index/lay" href="/index.php?r=index/lay" class="col-10-2 ">
            <i class="iconfont"><img src="https://img.alicdn.com/imgextra/i2/2053469401/TB2nLTXn7omBKNjSZFqXXXtqVXa-2053469401.png"></i>
            <span style="color: rgb(102, 102, 102);">分类</span>
        </a>

        <a data-mold="1" data-el="4" data-addr="/index.php?r=user/list" href="/index.php?r=user/list" class="col-10-2 ">
            <i class="iconfont"><img src="https://img.alicdn.com/imgextra/i1/2053469401/TB26bEfnQZmBKNjSZPiXXXFNVXa-2053469401.png"></i>
            <span style="color: rgb(102, 102, 102);">收藏</span>
        </a>

        <a data-mold="1" data-el="5" data-addr="/index.php?r=user/index" href="/index.php?r=user/index" class="col-10-2 ">
            <i class="iconfont"><img src="https://img.alicdn.com/imgextra/i3/2053469401/TB2WXrhqFkoBKNjSZFkXXb4tFXa-2053469401.png"></i>
            <span style="color: rgb(102, 102, 102);">我的</span>
        </a>
    </div>
</div>

<div class="layout " ui-up-app="">
    <!-- data-active="8" -->
    <div id="classifySwitch" class="ui_icon_tab fixed" data-fixed="true" ui-classify="" data-url="/index.php" data-config="{freeMode : true,slidesPerView : 'auto',pagination: '.swiper-pagination',paginationClickable: '.swiper-pagination'}" isload="true" style="top: 46px;">
        <div class="cent swiper-container-horizontal swiper-container-android">
            <div class="ant ">
                <a href="/index.php?r=index/wap" class="active ">精选</a>
            </div>
            <div class="swiper-container swiper-container3">
                <div class="swiper-wrapper">
                    <div class="swiper-slide"><a href="/index.php?r=index/cat&amp;cid=1">女装</a></div>
                    <div class="swiper-slide"><a href="/index.php?r=index/cat&amp;cid=6">美食</a></div>
                    <div class="swiper-slide"><a href="/index.php?r=index/cat&amp;cid=3">美妆</a></div>
                    <div class="swiper-slide"><a href="/index.php?r=index/cat&amp;cid=4">居家日用</a></div>
                    <div class="swiper-slide"><a href="/index.php?r=index/cat&amp;cid=9">男装</a></div>
                </div>
            </div>
            <a href="javascript:;" onclick="getClassify();" class="whole iconfont icon-xia"></a>
            <div class="ullit_tab" style="width:344px;">选择分类</div>
            <div class="ullit" style="width:344px;left:-50px;">
                <ul class="row-s col-mar">
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/wap">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i3/2053469401/TB2LX03HKuSBuNjy1XcXXcYjFXa-2053469401.png">
                            </i>
                            <span>精选</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=1">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i1/2053469401/TB2oX82HL9TBuNjy0FcXXbeiFXa-2053469401.png">
                            </i>
                            <span>女装</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=6">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i4/2053469401/TB2PFV2HL9TBuNjy0FcXXbeiFXa-2053469401.png">
                            </i>
                            <span>美食</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=3">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i1/2053469401/TB2QybZHL1TBuNjy0FjXXajyXXa-2053469401.png">
                            </i>
                            <span>美妆</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=4">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i3/2053469401/TB2FCJnHFGWBuNjy0FbXXb4sXXa-2053469401.png">
                            </i>
                            <span>居家日用</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=9">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i1/2053469401/TB2n7WyHN9YBuNjy0FfXXXIsVXa-2053469401.png">
                            </i>
                            <span>男装</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=5">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i1/2053469401/TB2g79yHN9YBuNjy0FfXXXIsVXa-2053469401.png">
                            </i>
                            <span>鞋品</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=8">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i3/2053469401/TB230SXHL9TBuNjy1zbXXXpepXa-2053469401.png">
                            </i>
                            <span>数码家电</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=2">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i4/2053469401/TB2QMv0ay6guuRjy1XdXXaAwpXa-2053469401.png">
                            </i>
                            <span>母婴</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=11">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i2/2053469401/TB27Cw.HwaTBuNjSszfXXXgfpXa-2053469401.png">
                            </i>
                            <span>箱包</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=10">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i3/2053469401/TB2cnZWzfiSBuNkSnhJXXbDcpXa-2053469401.png">
                            </i>
                            <span>内衣</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=7">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i4/2053469401/TB21.plHQKWBuNjy1zjXXcOypXa-2053469401.png">
                            </i>
                            <span>文娱车品</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=12">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i2/2053469401/TB2i36ZazfguuRjy1zeXXb0KFXa-2053469401.png">
                            </i>
                            <span>配饰</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=14">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i1/2053469401/TB2uI3VzcyYBuNkSnfoXXcWgVXa-2053469401.png">
                            </i>
                            <span>家装家纺</span>
                        </a>
                    </li>
                    <li class="col-12-3 text-center">
                        <a href="/index.php?r=index/cat&amp;cid=13">
                            <i class="iconfont ">
                                <img src="https://img.alicdn.com/imgextra/i4/2053469401/TB2rrnsHH9YBuNjy0FgXXcxcXXa-2053469401.png">
                            </i>
                            <span>户外运动</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="ui_icon_tab_bg"></div>
    <div class="ui_swiper">
        <div class="swiper-container hidden-xs swiper-container1">
            <div class="swiper-wrapper">
                <div class="swiper-slide" style="width: 344px;">
                    <a data-gid="16437958" data-ci="659473" data-in="1" data-uid="489217" data-cn="25" data-position="" ui-utm="" href="/index.php?r=p/d&amp;id=16437958" data-mold="3" data-el="1" data-addr="/index.php?r=p/d&amp;id=16437958">
                        <img src="https://img.alicdn.com/imgextra/i4/2508158775/O1CN012Egzw9z7CiQ2AGI_!!2508158775.jpg" alt="">
                    </a>
                </div>
                <div class="swiper-slide" style="width: 344px;">
                    <a data-gid="16431390" data-ci="658186" data-in="1" data-uid="489217" data-cn="25" data-position="" ui-utm="" href="/index.php?r=p/d&amp;id=16431390" data-mold="3" data-el="2" data-addr="/index.php?r=p/d&amp;id=16431390">
                        <img src="https://img.alicdn.com/imgextra/i2/2508158775/O1CN012Egzw8SNTimF6Zd_!!2508158775.jpg" alt="">
                    </a>
                </div>
                <div class="swiper-slide swiper-slide-prev" style="width: 344px;">
                    <a data-gid="16476316" data-ci="665368" data-in="1" data-uid="489217" data-cn="25" data-position="" ui-utm="" href="/index.php?r=p/d&amp;id=16476316" data-mold="3" data-el="3" data-addr="/index.php?r=p/d&amp;id=16476316">
                        <img src="https://img.alicdn.com/imgextra/i1/2508158775/O1CN012EgzwD5gZywwFyg_!!2508158775.jpg" alt="">
                    </a>
                </div>
                <div class="swiper-pagination swiper-p1"></div>
            </div>
        </div>
    </div>
    <div class="hr"></div>
    <div class="home_nav" style="layout:2;margin-bottom:5px;">
        <ul class="row-s" ui-mta-modular="" data-mta_name="首页-图标导航" isload="true">
            <li class="col-12-3">
                <a href="/index.php?r=nine" data-mold="0" data-el="1" data-addr="/index.php?r=nine">
                    <i class="iconfont">
                        <img src="https://img.alicdn.com/imgextra/i3/2053469401/TB22BQvoYZnBKNjSZFrXXaRLFXa-2053469401.png" alt="">
                    </i>9.9包邮</a>
            </li>
            <li class="col-12-3">
                <a href="/index.php?r=p" data-mold="0" data-el="2" data-addr="/index.php?r=p">
                    <i class="iconfont">
                        <img src="https://img.alicdn.com/imgextra/i1/2053469401/TB2G1wjoBnTBKNjSZPfXXbf1XXa-2053469401.png" alt="">
                    </i>疯抢排行</a>
            </li>
            <li class="col-12-3"><a href="/index.php?r=ddq" data-mold="0" data-el="3" data-addr="/index.php?r=ddq">
                <i class="iconfont">
                    <img src="https://img.alicdn.com/imgextra/i2/2053469401/TB2Z1Qso7UmBKNjSZFOXXab2XXa-2053469401.png" alt="">
                </i>咚咚抢</a>
            </li>
            <li class="col-12-3"><a href="/index.php?r=index/r" data-mold="0" data-el="4" data-addr="/index.php?r=index/r">
                <i class="iconfont">
                    <img src="https://img.alicdn.com/imgextra/i4/2053469401/TB2DEqooHZnBKNjSZFKXXcGOVXa-2053469401.png" alt="">
                </i>小编力荐</a></li>
        </ul>
    </div>
    <div class="hr"></div>
    <div class="home_ant_voucher" style="layout:2;margin-bottom:10px;">
        <h3 class="home_h3 row-s">
            <div class="col-mar">
                <div class="col-12-4 text-left">
                    <i></i>大家都在领
                </div>
                <div class="col-12-8 text-right" style="display:none">
                    <span ui-home-number="" data-time="2" isload="true">--.--.--.--</span> 次实时领券
                </div>
            </div>
        </h3>
        <div class="swiper-container swiper-container-android swiper-container2">
            <div id="indexCentreDIV" class="swiper-wrapper">
                <%--<div class="swiper-slide">
                    <div class="swiper-cent">
                        <div class="cent">
                            <a href="?r=p/dnew&amp;id=16484290" class="img" data-mold="3" data-el="1" data-addr="/index.php?r=l/d&amp;id=16484290">
                                <img src="https://img.alicdn.com/bao/uploaded/TB2QchRwmYTBKNjSZKbXXXJ8pXa_!!2130096995.png_310x310.jpg" alt="">
                                <p class="text">3.3万<span>人已领</span> <i>|</i> 40元券</p>
                            </a>
                            <p class="name">微商爆款【仁和】中华神皂二盒</p>
                            <p class="money"><i>¥</i>9.8 <del>¥49.8</del></p>
                            <p class="progress" data-progress="33"><i style="width: 33%;"></i></p>
                        </div>
                    </div>
                </div>--%>
            </div>
        </div>
        <div class="hr"></div>
        <h3 class="home_h3 row-s">
            <div class="col-mar">
                <div class="col-12-4 text-left">
                    <i></i>领券直播
                </div>
                <div class="col-12-8 text-right" style="">
                    今日已为用户省钱 <span ui-home-number="" data-num="56904170" data-time="2" isload="true">56,904,170</span> 元
                </div>
            </div>
        </h3>
        <ul  id="indexUl" class="goods-two"  isload="true">
            <%-- 获取商品列表--%>
            <%--<li class="row-s listpage1">
                <a href="/index.php?r=p/d&amp;id=16523368">
                    <p class="img">
                        <img ui-lazyload="" src="https://img.alicdn.com/imgextra/i4/1055530397/TB2nd5AegZC2uNjSZFnXXaxZpXa_!!1055530397-0-item_pic.jpg_310x310.jpg" style="background: rgb(245, 245, 245); display: block;">
                    </p>
                    <div class="cent">
                        <h3>新券~【佰草世家】草本美白面膜15片</h3>
                        <div class="num col-aaa ">
                            <span> 天猫价 ¥46</span><span class="fr">已售34.2万件</span>
                        </div>
                        <div class=" money col-money">
                            <p class="quan fr"><i>40元券</i></p>券后价 <span class=""><i>¥</i>6</span>
                        </div>
                    </div>
                </a>
            </li>--%>
        </ul>
    </div>
    <div style="display: none;"></div>
</div>
<div id="return-top">
    <a>
        <img src="../page/img/top.png">
    </a>
</div>
</body>
<script>
    var pageNo = 1;
    var pageSize = 8;
    new Swiper('.swiper-container1', {
        pagination: '.swiper-p1',
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
            delay: 2500,
            disableOnInteraction: false,
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
    });
    new Swiper('.swiper-container3', {
        direction: 'horizontal', // 垂直切换选项
        loop: true, // 循环模式选项
        centeredSlides: true,              //居中展示
        slidesPerView:'auto',
        spaceBetween:0,
    });
    //选择分类控制函数
    var classifySwitch = 0;
    function getClassify(){
        if(classifySwitch == 0 ){
            document.getElementById("classifySwitch").className = "ui_icon_tab fixed active";
            classifySwitch = 1;
        }else {
            document.getElementById("classifySwitch").className = "ui_icon_tab fixed";
            classifySwitch = 0;
        }
    }
    $(function(){
        $.ajax({
            url:""+"/app/index/getCentreList.do",
            async:false,
            data: {'pageNo':pageNo,'pageSize':pageSize},
            dataType:'json',
            type:"post",
            success:function(data){
                console.log(data);
                var arrLen = data.length;
                if(arrLen > 0){
                    var bannerHtml = '';
                    $.each(data,function(index,item){
                        bannerHtml+='<div class="swiper-slide"><div class="swiper-cent"><div class="cent"><a href="?r=p/dnew&amp;id=16484290" class="img" data-mold="3" data-el="1" data-addr="/index.php?r=l/d&amp;id=16484290"><img src="https://img.alicdn.com/bao/uploaded/TB2QchRwmYTBKNjSZKbXXXJ8pXa_!!2130096995.png_310x310.jpg" alt=""><p class="text">3.3万<span>人已领</span> <i>|</i> 40元券</p></a><p class="name">微商爆款【仁和】中华神皂二盒</p><p class="money"><i>¥</i>9.8 <del>¥49.8</del></p><p class="progress" data-progress="33"><i style="width: 33%;"></i></p></div></div></div></a></div>';
                    });
                    $("#indexCentreDIV").html(bannerHtml);
                    new Swiper('.swiper-container2', {
                        pagination: '.swiper-p2',
                        slidesPerView: 3,
                        spaceBetween: 0,
                        freeMode: true,
                        autoplay : 5000,
                        speed:1000,
                        loop: true,
                        initialSlide :0,
                        observer:true,//修改swiper自己或子元素时，自动初始化swiper
                        observeParents:true//修改swiper的父元素时，自动初始化swiper
                    });
                }
            }
        });

        //获取商品列表
        get_list();

        //下拉时加载页面元素
        $(window).scroll(function () {
            if ($(document).height() - $(this).scrollTop() - $(this).height() < 10) {
                get_list();
            }
        });
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
                        $.each(data,function(index,item){
                            var createLi = document.createElement("li");
                            createLi.className = "row-s listpage1";
                            createLi.innerHTML+="<a href=''>" +
                                "<p class='img'>" +
                                "<img src="+item.pictUrl+" style='background: rgb(245, 245, 245); display: block;'>" +
                                "</p>" +
                                "<div class='cent'>" +
                                "<h3>新券~"+item.shortTitle+"</h3>" +
                                "<div class='num col-aaa ><span> 天猫价 ¥"+item.zkFinalPrice+"</span>"+
                                "<span class='fr'>已售34.2万件</span>" +
                                "</div>" +
                                "<div class='money col-money'>" +
                                "<p class='quan fr'><i>40元券</i></p>券后价 <span><i>¥</i>6</span>" +
                                "</div>" +
                                "</div></a>"
                            document.getElementById("indexUl").appendChild(createLi);
                        });
                        pageNo++;
                    }
                }
            });
        }


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
</html>

