<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-dns-prefetch-control" content="on"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>搜索分类_淘券宝</title>
    <meta name="keywords" content="9.9包邮，白菜价，天天特价，优惠卷,淘券宝"/>
    <meta name="description" content="9.9包邮，白菜价，天天特价"/>
    <script src="http://cmsstatic.dataoke.com/other/jquery/1.12.4/jquery.min.js?v=201809201019"></script>
    <link href="http://cmsstatic.dataoke.com//web/css/wap_common.css?v=201809201019" rel="stylesheet"/>
    <link href="http://cmsstatic.dataoke.com//web/css/wap_search.css?v=201809201019" rel="stylesheet"/>
    <!-- 皮肤 S-->
    <link href="http://cmsstatic.dataoke.com//web/css/cms_skin/orange.css?v=201809201019" rel="stylesheet">        <!-- 皮肤 E-->
    <!-- 视频 S -->
    <link href="http://cmsstatic.dataoke.com//web/css/wap-video.css?v=201809201019" rel="stylesheet">
    <!-- 视频 E -->
    <script src="http://cmsstatic.dataoke.com//web/js/lazyload.js?v=201809201019" ></script>
    <script>
        //统计
        var coutData =[{"page":"0","event_name":"index_search","page_event":"click","page_class":"#search button","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"app_download_hover","page_event":"mouseenter","page_class":".app_download","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"record_number","page_event":"click","page_class":".miitbeian","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"service_bottom","page_event":"click","page_class":".footer_service","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"service_top","page_event":"click","page_class":".header_service","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"logo","page_event":"click","page_class":"#header .header_logo","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"home_set","page_event":"click","page_class":".set_home","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"collect_set","page_event":"click","page_class":".add_favorite","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"index_banner ","page_event":"click","page_class":".swiper-slide a","is_data":"gid","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"index_left_cid","page_event":"click","page_class":"#banner .list li a","is_data":"catid","is_posting_events":"0","is_num":"0","is_param":""},{"page":"r=index\/classify","event_name":"detail_top_search","page_event":"click","page_class":".search_submit","is_data":"","is_posting_events":"0","is_num":"0","is_param":""},{"page":"r=index\/classify","event_name":"detail_top_cid","page_event":"click","page_class":".main-cat  .cat-item  a","is_data":"catid","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"index_qlist_goods","page_event":"click","page_class":".live .goods-list li a","is_data":"gid","is_posting_events":"0","is_num":"0","is_param":""},{"page":"0","event_name":"index_search_fixed","page_event":"click","page_class":".floatNav .srcBtn","is_data":"","is_posting_events":"0","is_num":"0","is_param":""}];
    </script>
</head>

<style>
    .main-title .search {
        background-color: #fff;
        border-radius: 15px;
        margin-left: 12%;
        width: 65%;
        /*box-shadow: 0 1px 1px 1px #c86259;*/
    }
    /*.main-title .wap-srcBtn{ margin-right: 0; }*/

    .search-pop{
        display: none;
    }

    .src-content {
        margin: 20px 0 30px;
    }
    .toTop {
        position: fixed;
        right: 30px;
        bottom: 65px;
        font-family: iconfont;
        display: none;
        font-size: 37px;
        width: 50px;
        height: 50px;
        background-color: #fff;
        border: 1px solid #CCCCCC;
        border-radius: 50px;
        text-align: center;
        z-index: 11;
        line-height: 50px;
        color: #8c8c8c;
    }

    .main-src .src-item a {
        font-size: 13px;
        color: #333;
    }
    .src-item span{
        position: absolute;font-size: 12px;background-color: #FE4A65;right: -22px;
        top:-10px;color: #fff;border-radius: 12px;padding: 0 5px;line-height: 16px;
    }

    .search-cat .menu-content .main-cat li a {
        display: block;
        color: #333;
        font-size: 14px;
    }
    .search-land{
        display: none;
        position: fixed;width: 100%;height: 100%;background-color: #fff;z-index: 9999;top: 90px;overflow: hidden;
    }
    .search-land li{
        width: 90%;  border-bottom: 1px solid #f7f7f7;font-size: 13px;padding:9px 0;margin: 0 auto;
    }
    .search-land li a{
        color: #232326;width: 100%;
        display: inline-block;
    }
    .search .src-close-btn{
        display: none;
        position: absolute;right:0px;top: 0;
        background-image: url("http://cmsstatic.dataoke.com//web/images/cms-img.png?t=111");
        background-position: -107px 7px;
        background-repeat: no-repeat;
        background-size: 287px 800px;
        width: 28px;
        height: 28px;
        z-index: 9999;

    }

</style>
<body  data-appid="489217" data-in="1">
<div class="search-pop" style="display:block;">

    <div class="main-title clearfix theme-bg-color-1">
        <input type="hidden" name="wsw-status" value="1">
        <div class="search-tab">
            <a href="/index.php?r=index/classify&s_type=0" data-stype="0" class='my-sub-src cur '>搜券</a>

            <a href="/index.php?r=index/search&s_type=1&kw=" data-stype="1" class='my-sub-src '>搜全网</a>
        </div>

        <a href="javascript:;" class="close-src"></a>
        <form action="/index.php?r=index/index" method="GET" id="my-search" >
            <div class="search  fl" style="background-color: #fff;border-radius: 20px;width: 70%">
                <input type="hidden" name="r" value="index/search">
                <input type="hidden" name="s_type" value="0">
                <input type="text"  autocomplete="off"
                       placeholder="秋装热卖" value=""
                       name="kw" id="search_area"
                       class="old-search search_area" />

                <span class="src-close-btn"></span>

            </div>

            <button class="wap-srcBtn search_submit search-in background" type="submit" >搜 索</button>

        </form>
    </div>

    <script>
        $(".main-title .search-tab a").on("click",function(){
            $(".main-title .search-tab a").removeClass('cur');
            $(this).addClass('cur');
            $("input[name='s_type']").val($(this).data("stype"));
            var url = $(this).attr("href")+"&kws="+$("#my-search input[name='kw']").val();
            window.location.href=url;
            return false;
        });
        var kw_url = "/index.php?r=l&kw=%E7%A7%8B%E8%A3%85";
        $('#my-search').on('submit',function(){

            if($(this).find("input[name='kw']").val()=="" && kw_url != ""){
                window.location.href=kw_url;
                return false;
            }
            var value = $(this).find("input[name='kw']").val() ;
            /*触发mta 打开详细也统计*/
            MtaH5.clickStat("doSearch",{
                uid:$cmsLayer.getMtaCookie(),
                key: value == "" ? $(this).find("input[name='kw']").attr("placeholder") : value
            })
        });

    </script>

    <script>
        if($('.my-sub-src ').length>1){

        }else{
            $('#my-search .search').css('width','70%');
            $('.my-sub-src').removeClass('cur');
            $('.my-sub-src').css('opacity','1');
        }
    </script>



    <script>

        $('.sub_str_srarch').on('click',function(){

            var v= $(this).data('t');
            $('.s_type_value').val(v);
            /*触发mta 打开详细也统计*/
            var value = $("input[name='kw']").val() ;
            MtaH5.clickStat("doSearch",{
                uid:$cmsLayer.getMtaCookie(),
                key: value == "" ? $("input[name='kw']").attr("placeholder") : value
            })
            $('#my-search').submit();

        });


        if($('.my-sub-src ').length>1){
        }else{
            $('.my-sub-src').removeClass('cur')
        }

        $('.old-search.search_area').focus(function(){
//        $(".search-pop").css({"position":"absolute","top":"0"});
            $(".search-pop .main-title").css("position","absolute");
            $(".search-pop .search-cat").css({"position":"absolute","height":$(window).height()});
        });
        $('.old-search.search_area').focusout(function(){
//            $(".search-pop").css("position","fixed");
            $(".search-pop .main-title").css("position","fixed");
            $(".search-pop .search-cat").css("position","fixed");
        });


        //判断是否首页搜索框
        $(function(){
            if($('.wap-src-cat').length>0){
                $(".close-src").on('click',function(){
                    $(".search-pop").hide();
                    $('.search-land').hide();
                    $(".search-pop").find(".search_area").val('');
                    $('body').unbind('touchmove')
                    $('body').css('overflow-y','scroll');

                });
            }else{
            }

        })
        $(window).load(function() {
            /*触发mta 打开详细也统计*/
            MtaH5.clickStat("showPage",{
                uid:$cmsLayer.getMtaCookie(),
                time:((new Date()).getHours()<10 ? "0" + (new Date()).getHours() : (new Date()).getHours())+":"+((new Date()).getMinutes()<10 ? "0" + (new Date()).getMinutes() : (new Date()).getMinutes()),
                name:"搜索",
                'siteid':standId,
                'domainid':window.location.hostname.replace("www.","")
            })
        });
    </script>



</div>
<nav id="detail-top-menu">
    <div class="arrow"></div>
    <div class="mask" id="menu-mask2"></div>
    <div class="detail-menu-content">
        <ul class="main-detail">
            <li>
                <a href="/index.php?r=index/wap"><i class="iconfontv2 icon-detail_home"></i>首页</a>
            </li>
            <li>
                <a href="/index.php?r=index/classify"><i class="iconfontv2 icon-detail_search"></i>搜索</a>
            </li>
            <li>
                <a href="/index.php?r=index/customService"><i class="iconfontv2 icon-detail_servicer"></i>客服</a>
            </li>
            <li>
                <a href="/index.php?r=index/feedback&amp;id=16246604"><i class="iconfontv2 icon-datail_feedback"></i>反馈</a>
            </li>
            <li>
                <a href="/index.php?r=user/index"><i class="iconfontv2 icon-gerenzhongxin"></i>我的</a>
            </li>
        </ul>
    </div>
</nav>
<!-- 主界面具体展示内容 -->


<div class="search-cat">


    <div class="search-cat-tit">
        <span class="up-menu">热门搜索</span>
    </div>
    <div class="src-content">
        <ul class="main-src">
        </ul>
        <div class="cf"></div>
    </div>




    <div class="search-cat-tit">
        <span class="up-menu">商品分类</span>
    </div>
    <div class="menu-content">
        <ul class="main-cat">
            <li class="cat-item mm-nolistview">
                <a data-catid="4" href="/index.php?r=index/cat&cid=4&u=489217">居家日用</a>
            </li>
            <li class="cat-item ">
                <a data-catid="6" href="/index.php?r=index/cat&cid=6&u=489217">美食</a>
            </li>
            <li class="cat-item ">
                <a data-catid="2" href="/index.php?r=index/cat&cid=2&u=489217">母婴</a>
            </li>
            <li class="cat-item ">
                <a data-catid="3" href="/index.php?r=index/cat&cid=3&u=489217">美妆</a>
            </li>
            <li class="cat-item ">
                <a data-catid="1" href="/index.php?r=index/cat&cid=1&u=489217">女装</a>
            </li>
            <li class="cat-item ">
                <a data-catid="8" href="/index.php?r=index/cat&cid=8&u=489217">数码家电</a>
            </li>
            <li class="cat-item ">
                <a data-catid="7" href="/index.php?r=index/cat&cid=7&u=489217">文娱车品</a>
            </li>
            <li class="cat-item ">
                <a data-catid="10" href="/index.php?r=index/cat&cid=10&u=489217">内衣</a>
            </li>
            <li class="cat-item ">
                <a data-catid="14" href="/index.php?r=index/cat&cid=14&u=489217">家装家纺</a>
            </li>
            <li class="cat-item ">
                <a data-catid="5" href="/index.php?r=index/cat&cid=5&u=489217">鞋品</a>
            </li>
            <li class="cat-item ">
                <a data-catid="9" href="/index.php?r=index/cat&cid=9&u=489217">男装</a>
            </li>
            <li class="cat-item ">
                <a data-catid="12" href="/index.php?r=index/cat&cid=12&u=489217">配饰</a>
            </li>
            <li class="cat-item ">
                <a data-catid="13" href="/index.php?r=index/cat&cid=13&u=489217">户外运动</a>
            </li>
            <li class="cat-item ">
                <a data-catid="11" href="/index.php?r=index/cat&cid=11&u=489217">箱包</a>
            </li>
        </ul>
    </div>
</div>
<div class="toTop">&#xe6a4;</div>
<div style="display: none;">
</div>
<script src="http://cmsstatic.dataoke.com//web/js/cms_common.js?v=201809201019"></script>



<!--搜索弹窗-->

<div class="search-pop">
    <div class="search-cat">

        <div class="search-cat-tit">
            <span class="up-menu">热门搜索</span>
        </div>
        <div class="src-content">
            <ul class="main-src">
            </ul>
            <div style="clear: both"></div>
        </div>

        <div class="search-cat-tit ">
            <span class="up-menu">商品分类</span>
        </div>
        <div class="menu-content">
            <ul class="main-cat">
                <li class="cat-item mm-nolistview">
                    <a data-catid="4" href="/index.php?r=index/cat&cid=4&u=489217">居家日用</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="6" href="/index.php?r=index/cat&cid=6&u=489217">美食</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="2" href="/index.php?r=index/cat&cid=2&u=489217">母婴</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="3" href="/index.php?r=index/cat&cid=3&u=489217">美妆</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="1" href="/index.php?r=index/cat&cid=1&u=489217">女装</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="8" href="/index.php?r=index/cat&cid=8&u=489217">数码家电</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="7" href="/index.php?r=index/cat&cid=7&u=489217">文娱车品</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="10" href="/index.php?r=index/cat&cid=10&u=489217">内衣</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="14" href="/index.php?r=index/cat&cid=14&u=489217">家装家纺</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="5" href="/index.php?r=index/cat&cid=5&u=489217">鞋品</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="9" href="/index.php?r=index/cat&cid=9&u=489217">男装</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="12" href="/index.php?r=index/cat&cid=12&u=489217">配饰</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="13" href="/index.php?r=index/cat&cid=13&u=489217">户外运动</a>
                </li>
                <li class="cat-item ">
                    <a data-catid="11" href="/index.php?r=index/cat&cid=11&u=489217">箱包</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<ul class="search-land" >

</ul>
<style>
    .search .src-close-btn{
        right: 0!important;
    }
</style>
<!--搜索弹窗-->
</body>


<!--搜索弹窗-->
<script>
    //        判断搜索或是更多 改变搜索框长度
    // $('.search').width(Math.ceil($('.main-title').width())-85);
    //        $('body').on('click',function () {
    //            var myInput = document.getElementById('search_area');
    //            if(myInput==document.activeElement){
    //                $('.search_submit').show();
    //                $('#cat-action-menu').hide();
    //                $('.search').width(Math.ceil($('.main-title').width())-Math.ceil($('.main-back').width())-85);
    //            }else{
    //                $('.search_submit').hide();
    //                $('#cat-action-menu').show();
    //                $('.search').width(Math.ceil($('.main-title').width())-Math.ceil($('.main-back').width())-65);
    //            }
    //        });





    $(".old-search.search_area").on('click',function(){
//            $('#cat-action-menu').hide();
//            $('.search_submit').show();
        if($('.old-search.search_area').val()!==''){
            $('body').bind('touchmove',function(e){
                e.preventDefault();
            });
        }


        $('body').css('overflow-y','hidden');
        $('.search-kw').show();
        var _this =$(this);
        var _value = _this.val();
        if(_value==''){
            $(document).on('touchmove',function(e){
            });
            $(".search_area").focus();
        }else{
            $(document).on('touchmove',function(e){
            });
            $.fn.setCursorPosition = function(position){
                if(this.lengh == 0) return this;
                return $(this).setSelection(position, position);
            }

            $.fn.setSelection = function(selectionStart, selectionEnd) {
                if(this.lengh == 0) return this;
                input = this[0];

                if (input.createTextRange) {
                    var range = input.createTextRange();
                    range.collapse(true);
                    range.moveEnd('character', selectionEnd);
                    range.moveStart('character', selectionStart);
                    range.select();
                } else if (input.setSelectionRange) {
                    input.focus();
                    input.setSelectionRange(selectionStart, selectionEnd);
                }

                return this;
            }

            $.fn.focusEnd = function(){
                this.setCursorPosition(this.val().length);
            }

            $(".search_area").focusEnd();
            $(".search_area").val(_value);
            $('.search-land').show();
            $(".search-land").find('li').remove();

            var content = "";
            content = _value.replace(/\s+/g, "");
            if(content.length == 0){
                $('.search .src-close-btn').hide();
                $('.search-land').hide();
            }else{
                $('.search .src-close-btn').show();
                $('.search-land').show();
            }

            $.ajax({
                url: "/index.php?r=index/kwarr",
                type: 'get',
                dataType: 'json',
                data: {
                    kw: _value
                },
                success: function (data) {
                    if(data.status=='1'){
                        $(".search-land").find('li').remove();
                        for(var i=0;i< data.data.length;i++){
                            var str  = "<li>"+data.data[i]+"</li>";
                            $(".search-land").append(str);
                        }
                    }
                }
            })
        }

    });


    $(".close-src").on('click',function(){
        window.history.go(-1);
        $(".search-pop").css("position","fixed");
        $(".search-pop .main-title").css("position","fixed");
        $(".search-pop .search-cat").css("position","fixed");
        $('.search-land').hide();
        $(".search_area").val('');
        $('body').unbind('touchmove')
    });


    var bind_name = 'input';
    if (navigator.userAgent.indexOf("MSIE") != -1){
        bind_name = 'propertychange';
    }
    $(".search_area").bind(bind_name, function(){

        const _value = $(this).val();
        var content = "";
        content = _value.replace(/\s+/g, "");
        if(content.length == 0){
            $('.search .src-close-btn').hide();
            $('.search-land').hide();
        }else{
            $('.search .src-close-btn').show();
            $('.search-land').show();
        }

        $(".search-land").find('li').remove();

        $.ajax({
            url: "/index.php?r=index/kwarr",
            type: 'get',
            dataType: 'json',
            data: {
                kw: _value
            },
            success: function (data) {
                if(data.status=='1'){
                    $(".search-land").find('li').remove();
                    for(var i=0;i< data.data.length;i++){
                        var str  = "<li>"+data.data[i]+"</li>";
                        $(".search-land").append(str);
                    }
                }
            }
        })

    });

    $('.search .src-close-btn').click(function(){
        $('body').unbind('touchmove')
        $('body').css('overflow-y','scroll');
        $(this).hide();
        $('.search-land').hide();
        $(".search_area").val('');
        $('.search-kw').hide();
//             $('.search-pop').show();
        $(this).siblings('.search_area').focus();
    });

    $(".search-land").on('click','li',function(){
        $(".search_area").val($(this).text());
        $('.wap-srcBtn.search_submit').trigger('click');
    });

</script>
<script>
    var standId = 489217;
    var MtaH5={
        clickShare:function(){},
        clickStat:function(){},
        hack:function(){},
        pgv:function(){}
    };
    var _mtac = {"performanceMonitor":1,"senseQuery":1};
    (function() {
        var mta = document.createElement("script");
        mta.src = "//pingjs.qq.com/h5/stats.js?v2.0.4";
        mta.setAttribute("name", "MTAH5");
        mta.setAttribute("sid", "500625431");
        mta.setAttribute("cid", "500625432");
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(mta, s);
    })();
</script>
<script src="http://cmsstatic.dataoke.com//wap_new/lib/md5.js?v=201809201019"></script>
</html>
