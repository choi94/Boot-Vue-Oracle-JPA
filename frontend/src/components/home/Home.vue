<template>
    <div style="margin-top : 56px;">
    <Header></Header>
    <div>
  <mdb-carousel :interval="8000" showControls showIndicators>
    <mdb-carousel-item img src="https://mdbootstrap.com/img/Photos/Slides/img%20(77).jpg" mask="black-light" alt="First slide">
    </mdb-carousel-item>
    <mdb-carousel-item img src="https://mdbootstrap.com/img/Photos/Slides/img%20(78).jpg" mask="black-strong" alt="Second slide">
    </mdb-carousel-item>
  </mdb-carousel>
    </div>
    <div>
      <Footer></Footer>
    </div>
    </div>
</template>
<script>
  import {
      mdbCarousel,
      mdbCarouselItem,
      mdbCarouselCaption,
      } from 'mdbvue';

    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';

  export default {
    name: 'CarouselPage',
    components: {
      mdbCarousel,
      mdbCarouselItem,
      mdbCarouselCaption,
      Footer,
      Header
    }
  }
</script>
<style scoped>

</style>
