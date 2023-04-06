<template>
  <div
    class="py-4 container-fluid"
    style="align-items: center; justify-content: center; display: flex; flex-direction: column;"
  >
    <div style="position: absolute; top: 0px; left: 0px ">
      <nav
        class="navbar navbar-expand-sm bg-dark navbar-dark"
        style="width: 100vw;"
      >
        <div class="container-fluid">
          <router-link class="navbar-brand" :to="'/'">Beauty Spot</router-link>
          <div
            class="collapse navbar-collapse"
            id="collapsibleNavbar"
            style="margin-left: 80%;"
          >
            <ul class="navbar-nav">
              <li class="nav-item">
                <router-link class="nav-link" :to="'/'"
                  >สถิติการจองของร้าน</router-link
                >
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div
      style="height: auto; margin-top: 2%; display: flex; flex-direction: row;
              justify-content: space-between;
              align-items: center; flex-wrap: wrap; max-width: 90%"
    >
      <div
        class="col-lg-5"
        style="width: 400px; margin-top: 4%; margin-left: 20px; box-shadow: 1px 1px 20px grey;"
        v-for="promotion in result"
        v-bind:key="promotion.promotionId"
      >
        <div class="card h-100 p-3">
          <div
            class="overflow-hidden position-relative border-radius-lg bg-cover h-100"
            style="
              background-image: url('https://images.pexels.com/photos/6985259/pexels-photo-6985259.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
            "
          >
            <span class="mask bg-gradient-dark"></span>
            <div class="card-body position-relative z-index-1 p-3 h-100">
              <div class="d-flex flex-column h-100">
                <h5 class="text-black font-weight-bolder mb-4 pt-2">
                  {{ promotion.name }}
                </h5>
                <p class="text-black mb-5">
                  รับส่วนลด {{ promotion.percentDiscount }} %
                </p>
                <a
                  class="text-white font-weight-bold ps-1 mb-0 icon-move-left mt-auto"
                  :href="
                    '/reservation/' +
                      store.storeId +
                      '/' +
                      promotion.promotionId
                  "
                  style="font-size: 20px; border-radius: 8%; justify-content: center; text-align: center; width: 60px; height: 40px; color: white; background-color: black; text-decoration: none;"
                >
                  จอง
                  <i
                    class="fas fa-arrow-right text-sm ms-1"
                    aria-hidden="true"
                  ></i>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div
      style="font-size: 30px; color: white; display: block; flex-direction: column; text-align: center; align-items: center; justify-content: center; margin-top: 20px; border-radius: 8%; width: 80px; height: 50px; background-color: black;"
    >
      <a
        class="text-white font-weight-bold ps-1 mb-0 icon-move-left mt-auto"
        :href="'/storeselect'"
        style="text-decoration: none;"
      >
        กลับ
        <i class="fas fa-arrow-right text-sm ms-1" aria-hidden="true"></i>
      </a>
    </div>
  </div>
</template>
<script>
import Vue from 'vue'
import axios from 'axios'
Vue.use(axios)
export default {
  name: 'Promotion',
  data() {
    return {
      result: {},

      promotion: {
        promotionId: '',
        name: '',
        percentDiscount: ''
      },
      store: {
        storeId: ''
      }
    }
  },
  created() {
    this.PromotionLoad()
  },
  mounted() {
    this.store.storeId = this.$route.params.storeId
    console.log(this.store.storeId)
  },
  methods: {
    PromotionLoad() {
      var page = 'http://localhost:8080/promotions/'
      axios.get(page).then(({ data }) => {
        console.log(data)
        this.result = data.body
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
