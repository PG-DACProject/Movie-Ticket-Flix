import { Link } from "react-router-dom";
import 'font-awesome/css/font-awesome.min.css';
import "./Footer.css";
export default function Footer() {
  return (
    <footer className="Footer stick-bottom  text-center text-white mx-auto" style={{ background: "black",width:"96%" }}>

      <div className="container-fluid p-1"  >

        <a className="btn btn-outline-light btn-floating m-2" href="https://www.facebook.com/login.php" type="button"
        ><i className="fa fa-facebook-f"></i
        ></a>       

        <a className="btn btn-outline-light btn-floating m-2" href="https://myaccount.google.com/" Type="button"
        ><i className="fa fa-google"></i
        ></a>

        <a className="btn btn-outline-light btn-floating m-2" href="https://www.instagram.com/" type="button"
        ><i className="fa fa-instagram"></i
        ></a>

        <a className="btn btn-outline-light btn-floating m-2" href="https://www.linkedin.com/uas/login" type="button"
        ><i className="fa fa-linkedin"></i
        ></a>


        <a className="btn btn-outline-light btn-floating m-2" href="https://github.com/login" type="button"
        ><i className="fa fa-github"></i
        ></a>


      </div>
      <div>
        <h2>Multiplex Movie Booking</h2>
        <p>Contact No: +917879988100    &ensp; &ensp; &ensp;    Gmail: abhi94mehta@gmail.com</p>

      </div>


      <div className="text-center p-1" >
        © 2023 Copyright by Movie Ticket Flix Website
        
      </div>
<br />
    </footer>
  );
}
