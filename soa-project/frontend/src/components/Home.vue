<template>
  <div class="py-4 container-fluid">
    <div style="position: absolute; top: 0px; left: 0px">
      <nav
        class="navbar navbar-expand-sm bg-dark navbar-dark"
        style="width: 100vw;"
      >
        <div class="container-fluid">
          <router-link to="/">Beauty Spot</router-link>
          <div class="collapse navbar-collapse" id="collapsibleNavbar" style="margin-left: 80%;">
            <ul class="navbar-nav">
              <li class="nav-item">
                <router-link to="/">สถิติการจองของร้าน</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/">การจองทั้งหมด</router-link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
            <h2>Customer View</h2>
            <!--<table class="table table-dark">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">number</th>
                  <th scope="col">road</th>
                  <th scope="col">name</th>
                  <th scope="col">openTime</th>
                  <th scope="col">closeTime</th>
                  <th scope="col">phoneNumber</th>
                  <th scope="col">type</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="store in result" v-bind:key="store.storeId">
                  <td>{{ store.storeId }}</td>
                  <td>{{ store.number }}</td>
                  <td>{{ store.road }}</td>
                  <td>{{ store.name }}</td>
                  <td>{{ store.openTime }}</td>
                  <td>{{ store.closeTime }}</td>
                  <td>{{ store.phoneNumber }}</td>
                  <td>{{ store.type }}</td>
                  <td>
                    <button
                      type="button"
                      class="btn btn-warning"
                      @click="edit(customer)"
                    >
                      Edit
                    </button>
                    <button
                      type="button"
                      class="btn btn-danger"
                      @click="remove(customer)"
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              </tbody>
            </table>-->
      <div style="width: 100%; height: auto; margin-top: 10px">
        <div v-for="store in result" v-bind:key="store.storeId">
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
              <div class="card">
                <div class="card-body p-3">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="d-flex flex-column h-100">
                        <p class="mb-1 pt-2 text-bold">Beauty Spot {{ store.type }}</p>
                        <h5 class="font-weight-bolder">store name</h5>
                        <p class="mb-5">
                          <ul>
                            <div v-for="store in result" v-bind:key="store.storeId">
                              <li>{{ store.name }}   เวลาเปิด-ปิด : {{ store.openTime }}-{{ store.closeTime }}</li>
                            </div>
                          </ul>
                        </p>
                        <a
                          class="text-body text-sm font-weight-bold mb-0 icon-move-right mt-auto"
                          href="/storeselect"
                        >
                        จอง
                          <i
                            class="fas fa-arrow-right text-sm ms-1"
                            aria-hidden="true"
                          ></i>
                        </a>
                      </div>
                    </div>
                    <div class="col-lg-5 ms-auto text-center mt-5 mt-lg-0">
                      <div class="bg-gradient-success border-radius-lg h-100">
                        <img
                          src="../assets/img/shapes/waves-white.svg"
                          class="position-absolute h-100 w-50 top-0 d-lg-block d-none"
                          alt="waves"
                        />
                        <div
                          class="position-relative d-flex align-items-center justify-content-center h-100"
                        >
                          <img
                            class="w-100 position-relative z-index-2 pt-4"
                            src="../assets/img/illustrations/nail.jpg"
                            alt="rocket"
                          />
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
    </div>
  </div>
</template>
<script>
import Vue from 'vue'
import axios from 'axios'
Vue.use(axios)
export default {
  name: 'Home',
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
