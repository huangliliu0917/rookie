<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Swiper demo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="../js/swiper-4.4.1.min.css">

    <!-- Demo styles -->
    <style>
        html, body {
            position: relative;
            height: 100%;
        }
        body {
            background: #eee;
            font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
            font-size: 14px;
            color:#000;
            margin: 0;
            padding: 0;
        }
        .swiper-container {
            width: 100%;
            height: 100%;
        }
        .swiper-slide {
            text-align: center;
            font-size: 18px;
            background: #fff;
            /* Center slide text vertically */
            display: -webkit-box;
            display: -ms-flexbox;
            display: -webkit-flex;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            -webkit-align-items: center;
            align-items: center;
        }
    </style>
</head>
<body>

<!-- Swiper -->
<div class="swiper-container">

    <div class="swiper-wrapper">
        <div class="refresh">释放刷新</div>
        <div class="swiper-slide">Slide 1</div>
        <div class="swiper-slide">Slide 2</div>
        <div class="swiper-slide">Slide 3</div>
        <div class="swiper-slide">Slide 4</div>
        <div class="swiper-slide">Slide 5</div>
        <div class="swiper-slide">Slide 6</div>
        <div class="swiper-slide">Slide 7</div>
        <div class="swiper-slide">Slide 8</div>
        <div class="swiper-slide">Slide 9</div>
        <div class="loadmore">加载更多</div>
    </div>
    <div class="swiper-scrollbar"></div>
</div>

    <!-- Swiper JS -->
<script src="../js/swiper-4.4.1.min.js"></script>

<script>
    refreshEnd= false;
    times=0;//加载次数
    oriSpeed=300
    var swiper = new Swiper('.swiper-container',{
        speed: oriSpeed,
        slidesPerView: 'auto',
        freeMode: true,
        direction: 'horizontal',
        setWrapperSize: true,
        scrollbar: {
            el: '.swiper-scrollbar',
        },
        on:{
            //下拉释放刷新
            touchEnd: function(){
                swiper=this
                refreshText=swiper.$el.find('.refresh')
                if(this.translate>100){
                    swiper.setTransition(this.params.speed);
                    swiper.setTranslate(100);
                    swiper.touchEventsData.isTouched=false;//跳过touchEnd事件后面的跳转(4.0.5)
                    refreshText.html('刷新中')

                    swiper.allowTouchMove=false;
                    setTimeout(function(){//模仿AJAX
                        swiper.removeAllSlides();
                        for(i=0;i<20;i++){
                            swiper.appendSlide('<div class="swiper-slide">New Slide'+(i+1)+'</div>');
                            refreshText.html('刷新完成');
                            refreshEnd=true;
                            swiper.allowTouchMove=true;
                        }
                    },1000)

                }

            },
            touchStart: function(){
                if(refreshEnd==true){
                    this.$el.find('.refresh').html('释放刷新');
                    refreshEnd=false;
                }
            },

            //加载更多
            momentumBounce: function(){//非正式反弹回调函数，上拉释放加载更多可参考上例
                swiper=this
                //slidesheight=0;
                //for(h=0;h<swiper.slides.length;h++){
                //	slidesheight+=swiper.slides[h].offsetHeight;
                //}
                //endTranslate=this.height-slidesheight-20
                //if(this.translate < endTranslate){}
                if(swiper.translate<-100){

                    swiper.allowTouchMove=false;//禁止触摸
                    swiper.params.virtualTranslate=true;//定住不给回弹
                    setTimeout(function(){//模仿AJAX
                        for(m=0;m<20;m++){
                            swiper.appendSlide('<div class="swiper-slide">moreSlide'+(times*20+m+1)+'</div>');
                        }
                        swiper.params.virtualTranslate=false;
                        swiper.allowTouchMove= true;
                        times++
                    },1000)

                }
            },
        }
    });
</script>
</body>
</html>
