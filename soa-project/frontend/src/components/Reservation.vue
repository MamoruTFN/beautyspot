<template>
  <div class="py-4 container-fluid">
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
      <div style="width: 100%; height: auto; margin-top: 10px">
        <div
          class="row"
          style="
                      display: flex;
                      flex-direction: column;
                      justify-content: center;
                      align-items: center;
                      padding-bottom: 10px;
                      width: 98vw;
                    "
        >
          <div>
            <div class="page-header min-vh-75">
              <div class="container">
                <div class="row">
                  <div
                    class="mx-auto col-xl-4 col-lg-5 col-md-6 d-flex flex-column"
                  >
                    <div class="mt-8 card card-plain">
                      <div class="pb-0 card-header text-start">
                        <h3
                          class="font-weight-bolder text-success text-gradient"
                        >
                          Reservation
                        </h3>
                        <p class="mb-0">
                          กรอกข้อมูลการจองของท่าน
                        </p>
                      </div>
                      <div
                        class="card-body"
                        style="align-items: center; justify-content: center;"
                      >
                        <form role="form" class="text-start">
                          <label>ชื่อ</label>
                          <input
                            id="firstname"
                            type="text"
                            placeholder="Firstname"
                            name="firstname"
                          /><br />
                          <label>นามสกุล</label>
                          <input
                            id="lastname"
                            type="text"
                            placeholder="Lastname"
                            name="lastname"
                          /><br />
                          <label>เบอร์โทรศัพท์</label>
                          <input
                            id="tel"
                            type="text"
                            placeholder="Phone Number"
                            name="tel"
                          /><br />
                          <label>วันที่ต้องการจอง</label>
                          <input
                            id="reservationdate"
                            type="date"
                            placeholder="reservationdate"
                            name="reservationdate"
                          /><br />
                          <label>รายละเอียดเพิ่มเติม</label>
                          <input
                            id="description"
                            type="text"
                            placeholder="description"
                            name="description"
                          /><br />
                          <div class="text-center">
                            <button
                              class="my-4 mb-2"
                              variant="gradient"
                              color="success"
                              full-width
                            >
                              จอง
                            </button>
                          </div>
                        </form>
                      </div>
                      <div class="px-1 pt-0 text-center card-footer px-lg-2">
                        <p class="mx-auto mb-4 text-sm">
                          Don't have an account?
                          <router-link
                            :to="{ name: 'Sign Up' }"
                            class="text-success text-gradient font-weight-bold"
                            >Sign up</router-link
                          >
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div
                      class="top-0 oblique position-absolute h-100 d-md-block d-none me-n8"
                    >
                      <div
                        class="bg-cover oblique-image position-absolute fixed-top ms-auto h-100 z-index-0 ms-n6"
                        :style="{
                          backgroundImage:
                            'url(' +
                            require('@/assets/img/curved-images/curved9.jpg') +
                            ')'
                        }"
                      ></div>
                    </div>
                  </div>
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
import Vue from 'vue'
import axios from 'axios'
Vue.use(axios)
export default {
  name: 'Reservation',
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
