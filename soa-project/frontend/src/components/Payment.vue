<template>
  <div class="py-4 container-fluid">
    <div style="position: absolute; top: 0px; left: 0px">
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
      <div class="col-lg-12">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7"><br /></div>
        </div>
      </div>
      <button type="button" class="btn btn-primary" @click="showOthers()">
        แสดงรายการจองของท่าน
      </button>
      <div id="show" style="display: none;">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <div class="card">
              <div class="card-header pb-0 px-3">
                <h6 class="mb-0">Billing Information</h6>
              </div>

              <div class="card-body pt-4 p-3">
                <ul class="list-group">
                  <li
                    class="list-group-item border-0 d-flex p-4 mb-2 bg-gray-100 border-radius-lg"
                  >
                    <div class="d-flex flex-column">
                      <h6 class="mb-3 text-sm">
                        ชื่อร้าน : {{ result.storeName }}
                      </h6>
                      <span class="mb-2 text-xs">
                        ชื่อลูกค้า: {{ result.firstName }}
                        {{ result.lastName }}
                        <span class="text-dark font-weight-bold ms-sm-2"
                          >เบอร์โทรศัพท์ : {{ result.tel }}</span
                        ></span
                      ><span class="mb-2 text-xs">
                        โปรแกรมที่ทำ:
                        <span class="text-dark ms-sm-2 font-weight-bold">{{
                          result.storepriceName
                        }}</span></span
                      ><span class="mb-2 text-xs">
                        ส่วนลด:
                        <span class="text-dark ms-sm-2 font-weight-bold">{{
                          result.promotionName
                        }}</span></span
                      ><span class="text-xs">
                        ราคารวมส่วนลด:
                        <span class="text-dark ms-sm-2 font-weight-bold">{{
                          result.price
                        }}</span></span
                      >
                    </div>
                    <div class="ms-auto text-end">
                      <a
                        class="btn btn-link text-danger text-gradient px-3 mb-0"
                        ><button
                          type="button"
                          class="btn btn-danger"
                          @click="remove()"
                        >
                          ยกเลิก
                        </button>
                      </a>
                    </div>
                  </li>
                </ul>
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
  name: 'Payment',
  data() {
    return {
      result: {},

      payment: {
        storeName: '',
        phoneNumber: '',
        promotionName: '',
        firstName: '',
        lastName: '',
        storepriceName: '',
        reservationDate: '',
        price: '',
        paymentId: '',
        tel: ''
      },
      reservationid: ''
    }
  },
  created() {
    console.log('payment2')
  },
  mounted() {
    console.log('payment1')
  },
  methods: {
    saveData() {
      var page =
        'http://localhost:8080/payments/' + this.$route.params.reservationid

      axios.post(page).then(({ data }) => {
        console.log(data.body)
        this.result = data.body
        console.log(this.result)
      })
    },
    remove() {
      var page = 'http://localhost:8080/payments/' + this.result.paymentId

      axios.delete(page).then(({ data }) => {
        this.$router.push('/')
      })
    },
    showOthers() {
      this.saveData()
      document.getElementById('show').style.display = 'block'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
