<template>
  <div
    class="py-4 container-fluid"
    style="background-image: linear-gradient(90deg, rgba(201,251,143,1) 0%, rgba(115,255,69,1) 36%, rgba(0,255,189,1) 100%); min-height: 100vh;"
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
    <div style="width: 100%; height: auto; margin-top: 5%">
      <h2>Store View</h2>
      <div class="row">
        <div class="col-12">
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>Store List</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th
                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                      >
                        Store Name
                      </th>
                      <th
                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                      >
                        Location
                      </th>
                      <th
                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
                      >
                        Status
                      </th>
                      <th
                        class="text-center text-secondary text-xxs font-weight-bolder opacity-7"
                      >
                        OpenTime
                      </th>
                      <th
                        class="text-center text-secondary text-xxs font-weight-bolder opacity-7"
                      >
                        CloseTime
                      </th>
                      <th class="text-secondary opacity-7"></th>
                    </tr>
                  </thead>
                  <tbody v-for="store in result" v-bind:key="store.storeId">
                    <tr>
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div>
                            <soft-avatar
                              :img="img1"
                              size="sm"
                              border-radius="lg"
                              class="me-3"
                              alt="user1"
                            />
                          </div>
                          <div class="align-middle text-start">
                            <soft-badge
                              color="success"
                              variant="gradient"
                              size="sm"
                              >{{ store.name }}</soft-badge
                            >
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">
                          {{ store.number }} {{ store.road }}
                        </p>
                        <p class="text-xs text-secondary mb-0">
                          {{ store.province }} {{ store.district }}
                          {{ store.subdistrict }}
                        </p>
                      </td>
                      <td class="align-middle text-start">
                        <div
                          v-if="
                            timestamp >= store.openTime &&
                              timestamp < store.closeTime
                          "
                          style="border-radius: 8%; text-align: center; width: 70px; height: 30px; background-image: url('https://images.pexels.com/photos/6985259/pexels-photo-6985259.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');"
                        >
                          <soft-badge
                            color="success"
                            variant="gradient"
                            size="sm"
                            >online</soft-badge
                          >
                        </div>
                        <div
                          v-else
                          style="border-radius: 8%; text-align: center; width: 70px; height: 30px; background-color: red; color: white;"
                        >
                          <soft-badge
                            color="success"
                            variant="gradient"
                            size="sm"
                            >offline</soft-badge
                          >
                        </div>
                      </td>
                      <td class="align-middle text-center">
                        <span class="text-secondary text-xs font-weight-bold">{{
                          store.openTime
                        }}</span>
                      </td>
                      <td class="align-middle text-center">
                        <span class="text-secondary text-xs font-weight-bold">{{
                          store.closeTime
                        }}</span>
                      </td>
                      <td class="align-middle">
                        <div
                          style="font-size: 20px; border-radius: 8%; justify-content: center; text-align: center; width: 60px; height: 40px; color: white; background-color: black;"
                        >
                          <a
                            :href="'/promotion/' + store.storeId"
                            class="font-weight-bold"
                            data-toggle="tooltip"
                            data-original-title="Edit user"
                            style="text-decoration: none; color: white;"
                            >จอง</a
                          >
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div
        style="width: 100%; height: auto; display: flex; flex-direction: column; text-align: center; align-items: center; justify-content: center;"
      >
        <div
          style="font-size: 30px; color: white; display: block; flex-direction: column; text-align: center; align-items: center; justify-content: center; margin-top: 20px; border-radius: 8%; width: 80px; height: 50px; background-color: black;"
        >
          <a
            class="text-white font-weight-bold ps-1 mb-0 icon-move-left mt-auto"
            :href="'/'"
            style="text-decoration: none;"
          >
            กลับ
            <i class="fas fa-arrow-right text-sm ms-1" aria-hidden="true"></i>
          </a>
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
  name: 'StoreSelect',
  data() {
    return {
      result: {},

      store: {
        storeId: '',
        number: '',
        road: '',
        name: '',
        subdistrict: '',
        district: '',
        province: '',
        openTime: '',
        closeTime: '',
        phoneNumber: '',
        type: ''
      },
      timestamp: ''
    }
  },
  created() {
    this.currentDate()
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
    },
    currentDate() {
      var today = new Date()
      const time =
        today.getHours() + ':' + today.getMinutes() + ':' + today.getSeconds()
      this.timestamp = time
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
