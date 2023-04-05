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
                        <soft-badge color="success" variant="gradient" size="sm"
                          >online</soft-badge
                        >
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
                        <a
                          href="/promotion"
                          class="text-secondary font-weight-bold text-xs"
                          data-toggle="tooltip"
                          data-original-title="Edit user"
                          >จอง</a
                        >
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
