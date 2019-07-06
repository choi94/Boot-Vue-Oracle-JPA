<template>
  <div>
  <mdb-navbar color="stylish" position="top" dark>
    <router-link to="/">
    <div v-if="this.$store.state.session_email != ''">
      <mdb-navbar-brand class="font-weight-bold mr-3">
        {{ this.$store.state.session_email }}
      </mdb-navbar-brand>
    </div>
    <div v-else>
      <mdb-navbar-brand class="font-weight-bold mr-3">
        choi
      </mdb-navbar-brand>
    </div>
    </router-link>
    <mdb-navbar-toggler>
      <mdb-navbar-nav>
        <div class="d-flex" v-if="this.$store.state.session_email === ''">
          <router-link to="/login"><mdb-nav-item class="mx-3" active>Login</mdb-nav-item></router-link>
          <router-link to="/join"><mdb-nav-item class="mx-3" active>Join</mdb-nav-item></router-link>
        </div>
        <router-link to="/board"><mdb-nav-item class="mx-3" active>Board</mdb-nav-item></router-link>
        <mdb-dropdown tag="li" class="nav-item mx-3">
            <mdb-dropdown-toggle tag="a" navLink slot="toggle" waves-fixed>Information</mdb-dropdown-toggle>
            <mdb-dropdown-menu>
              <mdb-dropdown-item><router-link to="/technology">Technology</router-link></mdb-dropdown-item>
              <mdb-dropdown-item href="https://github.com/choi94/Boot-Vue-H2-JPA">Github</mdb-dropdown-item>
            </mdb-dropdown-menu>
        </mdb-dropdown>
        <div class="d-flex" v-if="this.$store.state.session_email != ''">
          <mdb-nav-item @click="logout" class="mx-3" active>로그아웃</mdb-nav-item>
        </div>
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>
  </div>

</template>
<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbDropdown, mdbDropdownMenu, mdbDropdownToggle, mdbInput, mdbDropdownItem } from 'mdbvue';
  export default {
    name: 'NavbarPage',
    components: {
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
      mdbDropdown,
      mdbDropdownMenu,
      mdbDropdownToggle,
      mdbDropdownItem,
      mdbInput
    },
    methods : {
      logout() {
        this.$store.dispatch('LOGOUT')
          .then()
          .catch( () => alert('오류'))
      }
    }
  }
</script>
<style scoped>

</style>
