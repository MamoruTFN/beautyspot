<template>
  <div class="py-4 container-fluid">
    <div style="position: absolute; top: 0px; left: 0px">
      <nav
        class="navbar navbar-expand-sm bg-dark navbar-dark"
        style="width: 98vw"
      >
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Beauty Spot</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#collapsibleNavbar"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#">ประวัติการจอง</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">การชำระเงิน</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">ข้อมูลของฉัน</a>
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
                    "
        >
          <div>
            <h2>Customer View</h2>
          </div>
          <form @submit.prevent="saveData">
            <input
              type="text"
              v-model="reservationDTO.firstName"
              class="form-control"
              placeholder="firstName"
            />
            <input
              type="text"
              v-model="reservationDTO.lastName"
              class="form-control"
              placeholder="lastName"
            /><input
              type="text"
              v-model="reservationDTO.tel"
              class="form-control"
              placeholder="tel"
            />
            <input
              type="hidden"
              v-model="reservationDTO.currentDate"
              class="form-control"
              placeholder="currentDate"
            />
            <input
              type="date"
              v-model="reservationDTO.reservationDate"
              class="form-control"
              placeholder="reservationDate"
            />
            <select v-model="storePrice.storePriceId" class="form-control">
              <option
                v-for="storePrice in result"
                v-bind:key="storePrice.storePriceId"
                v-bind:value="storePrice.storePriceId"
                >{{ storePrice.name }}</option
              >
            </select>
            <input
              type="text"
              v-model="reservationDTO.description"
              class="form-control"
              placeholder="description"
            />
            <router-link
              :to="'/promotion/' + this.$route.params.storeid"
              class="btn btn-secondary"
              >กลับ</router-link
            >
            <button type="submit" class="btn btn-danger">
              สร้าง
            </button>
          </form>
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
      selected: '',
      reservationDTO: {
        firstName: '',
        lastName: '',
        tel: '',
        currentDate: '',
        reservationDate: '',
        description: ''
      },
      reservationid: '',
      storePrice: {
        storePriceId: '',
        price: '',
        name: ''
      }
    }
  },
  created() {
    this.ReservationLoad()
    this.StorepriceLoad()
  },
  mounted() {
    console.log(this.$route.params.storeid)
    console.log(this.$route.params.promotionid)
  },
  methods: {
    ReservationLoad() {
      var page = 'http://localhost:8080/reservations/max'
      axios.get(page).then(({ data }) => {
        console.log(data)
        this.reservationid = data.body.reservationId
        console.log(this.reservationid)
      })
    },
    StorepriceLoad() {
      var page =
        'http://localhost:8080/storeprice/price/' + this.$route.params.storeid
      axios.get(page).then(({ data }) => {
        this.result = data.body
      })
    },
    saveData() {
      var page =
        'http://localhost:8080/reservations/?storepriceId=' +
        this.storePrice.storePriceId +
        '&promotionId=' +
        this.$route.params.promotionid
      axios.post(page, this.reservationDTO).then(({ data }) => {
        this.reservationDTO.firstName = ''
        this.reservationDTO.lastName = ''
        this.reservationDTO.tel = ''
        this.reservationDTO.currentDate = ''
        this.reservationDTO.reservationDate = ''
        this.reservationDTO.description = ''
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
