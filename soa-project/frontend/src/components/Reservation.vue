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
          <div class="col-lg-7 mb-lg-0 mb-4">
            <div class="card" style="box-shadow: 1px 1px 20px grey;">
              <div class="card-body p-3">
                <h2>Reservation View</h2>
                <form
                  @submit.prevent="saveData"
                  style="display: block; align-items: center; justify-content: center;"
                >
                  <div
                    style="display: flex; align-items: center; justify-content: center;"
                  >
                    <div
                      style="width: 20%; display: block; align-items: start; margin-top: 10px;"
                    >
                      <a>ชื่อ</a>
                    </div>
                    <input
                      type="text"
                      v-model="reservationDTO.firstName"
                      class="form-control"
                      placeholder="firstName"
                      style="width: 50%;"
                      required
                    />
                  </div>
                  <div
                    style="display: flex; align-items: center; justify-content: center; margin-top: 10px;"
                  >
                    <div
                      style="width: 20%; display: block; align-items: start;"
                    >
                      <a>นามสกุล</a>
                    </div>
                    <input
                      type="text"
                      v-model="reservationDTO.lastName"
                      class="form-control"
                      placeholder="lastName"
                      style="width: 50%;"
                      required
                    />
                  </div>
                  <div
                    style="display: flex; align-items: center; justify-content: center; margin-top: 10px;"
                  >
                    <div
                      style="width: 20%; display: block; align-items: start;"
                    >
                      <a>เบอร์โทรศัพท์</a>
                    </div>
                    <input
                      type="text"
                      v-model="reservationDTO.tel"
                      class="form-control"
                      placeholder="tel"
                      style="width: 50%;"
                      required
                    />
                  </div>
                  <div
                    style="display: flex; align-items: center; justify-content: center; margin-top: 10px;"
                  >
                    <div
                      style="width: 20%; display: block; align-items: start;"
                    >
                      <a>วันที่ต้องการจอง</a>
                    </div>
                    <input
                      type="date"
                      v-model="reservationDTO.reservationDate"
                      class="form-control"
                      placeholder="reservationDate"
                      style="width: 50%;"
                      required
                    />
                  </div>
                  <div
                    style="display: flex; align-items: center; justify-content: center; margin-top: 10px;"
                  >
                    <div
                      style="width: 20%; display: block; align-items: start;"
                    >
                      <a>เลือกสิ่งที่จะทำ</a>
                    </div>
                    <select
                      v-model="storePrice.storePriceId"
                      class="form-control"
                      style="width: 50%;"
                    >
                      <option
                        v-for="storePrice in result"
                        v-bind:key="storePrice.storePriceId"
                        v-bind:value="storePrice.storePriceId"
                        >{{ storePrice.name }}</option
                      >
                    </select>
                  </div>
                  <div
                    style="display: flex; align-items: center; justify-content: center; margin-top: 10px;"
                  >
                    <div
                      style="width: 20%; display: block; align-items: start;"
                    >
                      <a>รายละเอียดเพิ่มเติม</a>
                    </div>
                    <input
                      type="text"
                      v-model="reservationDTO.description"
                      class="form-control"
                      placeholder="description"
                      style="width: 50%;"
                      required
                    />
                  </div>
                  <div
                    style="width: 100%; height: auto; display: flex; align-items: center; flex-direction: row; justify-content: center;"
                  >
                    <div
                      style="display: flex; align-items: center; justify-content: space-between; margin-top: 20px; width: 250px;"
                    >
                      <router-link
                        :to="'/promotion/' + this.$route.params.storeid"
                        class="btn btn-secondary"
                        style="display: block; align-items: center; flex-direction: column; justify-content: center; font-size: 20px; border-radius: 8%; text-align: center; width: 100px; height: 40px; background-color: black; outline: none; border-style: none!important;"
                        >กลับ</router-link
                      >
                      <button
                        type="submit"
                        style="display: block; align-items: center; flex-direction: column; justify-content: center; font-size: 30px; border-radius: 8%; text-align: center; width: 100px; height: 40px; background-image: url('https://images.pexels.com/photos/6985259/pexels-photo-6985259.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'); outline: none; border-style: none!important;"
                      >
                        สร้าง
                      </button>
                    </div>
                  </div>
                </form>
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
