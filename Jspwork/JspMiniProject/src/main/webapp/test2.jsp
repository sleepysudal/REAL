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

<title>포스터 자동재생  테스트</title>
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
      }

     .swiper-slide img {
        display: block;
        width: 600px;
        height: 1000px;
        object-fit: cover;
        
      }
     
      
    </style>
</head>
<body>
  <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="image/poster1.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster2.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster3.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster5.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster6.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster7.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster8.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster9.jpeg"></div>
        <div class="swiper-slide"><img src="image/poster10.jpeg"></div>
       
      </div>
      
     </div>

<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

 <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        spaceBetween: 30,
        centeredSlides: true,
        
        autoplay: {
         delay: 1000,
          disableOnInteraction: false,
        },
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