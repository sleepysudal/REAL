<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"
/>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>스와이프 테스트</title>
<style>
      html,
      body {
        position: relative;
        height: 100%;
      }

      body {
        background: #eee;
        font-family: gugi;
        font-size: 14px;
        color: #000;
        margin: 0;
        padding: 0;
      }

      .swiper {
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
        flex-direction: column;
      }

    
     
      .swiper-slide img {
        display: block;
        width: 600px;
        height: 300px;
        object-fit: cover;
       
      }
      .swiper-button-next{
      opacity: 0.1;
      
      }
      .swiper-button-prev{
      opacity: 0.1;
        }
       .text1{
       z-index:2;
       font-family: 'gugi';
       font-size:23pt;
       }
       .block{
       display: block;
       }
       .swiper-button-prev:after, .swiper-rtl .swiper-button-next:after{
       display: none;
       }
    </style>
</head>
<body>
  <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide">1등<img src="image/poster1.jpeg"><h3 class="block">백두산</h3>
        <h6>좋아요 99%&nbsp;예매율56%</h6></div>
        <div class="swiper-slide">2등<img src="image/poster2.jpeg"><h3 class="block">엘리멘탈</h3>
        <h6>좋아요 92%&nbsp;예매율50%</h6></div>
        <div class="swiper-slide">3등<img src="image/poster3.jpeg"><h3 class="block">오펜하이머</h3>
        <h6>좋아요88%&nbsp;예매율49%</h6></div>
        <div class="swiper-slide">4등<img src="image/poster4.jpeg"><h3 class="block">바비</h3>
        <h6>좋아요86%&nbsp;예매율48%</h6></div>
      </div>
      <div class="swiper-button-next"><img src="image/rightarrow.png" style="width:100px; height:100px;"></div>
      <div class="swiper-button-prev"><img src="image/leftarrow.png" style="width:100px; height:100px;"></div>
      <div class="swiper-pagination"></div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

 <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        spaceBetween: 30,
        centeredSlides: true,
        
       	pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });

    </script>
</body>
</html>