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
      <div class="col-lg-12">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7"><br /></div>
        </div>
      </div>
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
                    <h6 class="mb-3 text-sm">Oliver Liam</h6>
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
                    ><a
                      class="btn btn-link text-dark px-3 mb-0"
                      href="javascript:;"
                      ><i
                        class="fas fa-pencil-alt text-dark me-2"
                        aria-hidden="true"
                      ></i
                      >Edit
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

      reservationDTO: {
        firstName: '',
        lastName: '',
        tel: '',
        currentDate: '',
        reservationDate: '',
        description: ''
      },
      reservationid: ''
    }
  },
  created() {
    this.saveData()
  },
  mounted() {
    console.log(this.$route.params.storeid)
    console.log(this.$route.params.promotionid)
  },
  methods: {
    saveData() {
      var today = new Date()
      var page =
        'http://localhost:8080/payments/?reservationId' +
        this.$route.params.reservationid +
        '&promotionId=' +
        today
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
