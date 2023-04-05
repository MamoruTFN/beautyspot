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
            <div v-for="store in result" v-bind:key="store.storeId">
              <h6>{{ store.storeId }}<br />{{ store.number }}</h6>
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
  name: 'HelloWorld',
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
