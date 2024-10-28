import { Router } from "express";
import UserController from "../controller/UserController.js";
import checkToken from "../../../config/auth/checkToken.js";
const router = Router();

router.get("/api/user/email/:email", UserController.findByEmail);
router.use(checkToken);
router.post("/api/user/auth", UserController.getAccessToken);
export default router;