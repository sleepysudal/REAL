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

    </style>
</head>
<body>
  <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="image/banner0.jpeg"><h1 class="block">1번 장순영</h1></div>
        <div class="swiper-slide"><img src="image/banner1.jpeg"><h1 class="block">2번 장순영</h1></div>
        <div class="swiper-slide"><img src="image/banner3.png"><h1 class="block">3번 장순영</h1></div>
        <div class="swiper-slide"><img src="image/canada1.jpeg"><h1 class="block">4번 장순영</h1></div>
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