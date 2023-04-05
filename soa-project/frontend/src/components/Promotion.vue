<template>
  <div
    class="py-4 container-fluid"
    style="align-items: center; justify-content: center; display: flex"
  >
    <div style="position: absolute; top: 0px; left: 0px">
      <nav
        class="navbar navbar-expand-sm bg-dark navbar-dark"
        style="width: 100vw;"
      >
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Beauty Spot</a>
          <div
            class="collapse navbar-collapse"
            id="collapsibleNavbar"
            style="margin-left: 80%;"
          >
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#">สถิติการจองของร้าน</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div
      style="width: 900px; height: auto; margin-top: 2%; display: flex; flex-direction: row;
              justify-content: space-between;
              align-items: center; flex-wrap: wrap; max-width: 90%"
    >
      <div
        class="col-lg-5"
        style="width: 400px; margin-top: 4%;"
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
                <h5 class="text-white font-weight-bolder mb-4 pt-2">
                  {{ promotion.name }}
                </h5>
                <p class="text-white mb-5">
                  รับส่วนลด {{ promotion.percentDiscount }} %
                </p>
                <a
                  class="text-white font-weight-bold ps-1 mb-0 icon-move-left mt-auto"
                  href="/reservation"
                >
                  Read more
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
      }
    }
  },
  created() {
    this.CustomereLoad()
  },
  mounted() {
    console.log('mounted() called.......')
  },
  methods: {
    CustomereLoad() {
      var page = 'http://localhost:8080/stores/'
      axios.get(page).then(({ data }) => {
        console.log(data)
        this.result = data.body
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
