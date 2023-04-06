<template >
  <section
    style="background-color: #f0ffff; padding: 0; margin: 0; height: 100%"
  >
    <div id="app">
      <div id="app">
        <div class="py-4 container-fluid">
          <div style="position: absolute; top: 0px; left: 0px">
            <nav
              class="navbar navbar-expand-sm bg-dark navbar-dark"
              style="width: 100vw"
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
          </div>
        </div>
        <router-view />
      </div>
    </div>

    <div class="py-4 container-fluid">
      <div
        style="
          width: 100%;
          height: auto;
          margin-top: 5%;
          display: flex;
          justify-content: center;
        "
      >
        <div class="card" style="width: 50%">
          <div class="card-body">
            <li
              class="list-group-item border-0 d-flex p-4 mb-2 bg-gray-100 border-radius-lg"
            >
              <div class="d-flex flex-column">
                <h6 class="mb-3 text-sm">{{ customer.firstName }}</h6>
                <span class="mb-2 text-xs">
                  Company Name:
                  <span class="text-dark font-weight-bold ms-sm-2"
                    >Viking Burrito</span
                  ></span
                ><span class="mb-2 text-xs">
                  Email Address:
                  <span class="text-dark ms-sm-2 font-weight-bold"
                    >oliver@burrito.com</span
                  ></span
                ><span class="text-xs">
                  VAT Number:
                  <span class="text-dark ms-sm-2 font-weight-bold"
                    >FRB1235476</span
                  ></span
                >
              </div>
              <div class="ms-auto text-end">
                <a
                  class="btn btn-link text-danger text-gradient px-3 mb-0"
                  href="javascript:;"
                  ><i class="far fa-trash-alt me-2" aria-hidden="true"></i
                  >Delete </a
                ><a class="btn btn-link text-dark px-3 mb-0" href="javascript:;"
                  ><i
                    class="fas fa-pencil-alt text-dark me-2"
                    aria-hidden="true"
                  ></i
                  >Edit
                </a>
              </div>
            </li>
          </div>
        </div>
      </div>
    </div>

    <div
      style="
        display: flex
        justify-content: center;
        flex-direction: column;
        margin-inline: 30%;
      "
    >
      <h5>Payment and Promption</h5>
      <div style="padding-inline: 100px; display: flex; flex-direction: column">
        <label for="quantity">quantity:</label>
        <input type="number" id="quantity" v-model="quantity" />

        <label for="price">Price:</label>
        <input type="number" id="price" v-model="price" />

        <label for="discount">Discount:</label>
        <input type="number" id="discount" v-model="discount" />

        <p style="margin-top: 30px">Summit: {{ totalPrice }}</p>
      </div>
    </div>
  </section>
</template>

<script>
import Vue from 'vue'
import axios from 'axios'
Vue.use(axios)
export default {
  data() {
    return {
      result: {},
      customer: {
        firstName: '',
        LastName: '',
        tel: ''
      },
      quantity: 0,
      price: 0,
      discount: 0
    }
  },
  computed: {
    totalPrice() {
      let total = this.quantity * this.price
      if (this.quantity >= 2) {
        total = total - (total * this.discount) / 100
      }
      return total
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
      var page = 'http://localhost:8080/customer/1'
      axios.get(page).then(({ data }) => {
        console.log(data)
        this.result = data.body
      })
    }
  }
}
</script>

<style scoped>
/* .all {
  flex: 1 width 1000px;
  height: 1000px;
  display: flex;
  justify-content: center;
}
.sum {
  background-color: blue;
  flex: 3 width 500px;
  height: 500px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  gap: 10px;
}
.user {
  background-color: bisque;
  padding: 80px;
  display: flex;
}
.customer {
  background-color: black;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.button {
  background-color: aqua;
  width: 300px;
  height: 100px;
  display: flex;
  justify-content: center;
  flex-direction: column;
} */
