<template>
  <div class="py-4 container-fluid">
    <div style="position: absolute; top: 0px; left: 0px;">
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="width: 99vw;">
        <div class="container-fluid">
          <a class="navbar-brand" href="/">Beauty Spot</a>
          <div class="collapse navbar-collapse" id="collapsibleNavbar" style="margin-left: 80%;">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#">สถิติการจองของร้าน</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div>
        <div class="row" style="
                      margin-top: 10px;
                      display: flex;
                      flex-direction: column;
                      justify-content: center;
                      align-items: center;
                      padding-bottom: 10px;
                      width: 98vw;
                    ">
          <div class="col-lg-8 col-md-6 mb-md-0 mb-4">
            <div class="card mb-4">
              <div class="card-header pb-0">
                <h6>สถิติการจองของร้าน</h6>
              </div>
              <div class="card-body px-0 pt-0 pb-2">
                <div class="table-responsive p-0">
                  <table class="table align-items-center justify-content-center mb-0">
                    <thead>
                      <tr>
                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                          ชื่อร้าน
                        </th>
                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                          ประเภท
                        </th>
                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                          เบอร์โทร
                        </th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr v-for="store in result" v-bind:key="store.storeId">
                        <td>
                          <div class="d-flex px-2">
                            <div >
                              <div >
                                <img src="../assets/img/shapes/waves-white.svg"
                                  class="position-absolute h-100 w-50 top-0 d-lg-block d-none" alt="waves" />
                                <div v-if="store.type = 'ผม'"
                                  class="position-relative d-flex align-items-center justify-content-center h-100">
                                  <img
                                    style="width: 90px;"
                                    src="https://i.pinimg.com/564x/ae/6c/95/ae6c95bd2e0dc2053e49e992380b18c3.jpg"
                                    alt="rocket" />
                                </div>
                                <div v-else-if="store.type = 'เล็บ'"
                                  class="position-relative d-flex align-items-center justify-content-center h-100">
                                  <img class="w-100 position-relative z-index-2 pt-4"
                                    src="https://i.pinimg.com/564x/3f/4d/75/3f4d750e86ba565b0b7eebf6ba3a29aa.jpg"
                                    alt="rocket" />
                                </div>
                                <div v-else-if="store.type = 'นวด'"
                                  class="position-relative d-flex align-items-center justify-content-center h-100">
                                  <img class="w-100 position-relative z-index-2 pt-4"
                                    src="https://i.pinimg.com/564x/5e/5c/bd/5e5cbd4d3517ba13db403b2145f91b07.jpg"
                                    alt="rocket" />
                                </div>
                              </div>
                            </div>
                            <div class="my-auto">
                              <h6 class="mb-0 text-sm">{{ store.name }}</h6>
                            </div>
                          </div>
                        </td>
                        <td>
                          <p class="text-sm font-weight-bold mb-0">{{ store.type }}</p>
                        </td>
                        <td>
                          <span class="text-xs font-weight-bold">{{ store.phoneNumber }}</span>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>
<script>
import img from '../assets/img/small-logos/logo-invision.svg'
import Vue from 'vue'
import axios from 'axios'
Vue.use(axios)
export default {
  name: 'Statistics',
  data() {
    return {
      result: {},

      store: {
        storeId: '',
        number: '',
        road: '',
        name: '',
        openTime: '',
        closeTime: '',
        phoneNumber: '',
        type: ''
      },
      img
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
      var page = 'http://localhost:8080/stores/ranking'
      axios.get(page).then(({ data }) => {
        console.log(data)
        this.result = data.body
      })
    }
  }
}
</script>
