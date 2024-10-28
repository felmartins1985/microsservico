import { Sequelize } from "sequelize";

const sequelize = new Sequelize("auth-db", "admin", "123456",{
  host: "auth-db",
  dialect: "postgres",
  quoteIdentifiers: false,
  define:{
    syncOnAssociation: true,
    timestamps: false,
    underscored: true,
    underscoredAll: true,
    freezeTableName: true,
  }
})
sequelize.authenticate().then(() => {
  console.log("Connection has been established successfully.");
}).catch((error) => {
  console.error("Unable to connect to the database:", error.message);
})

export default sequelize;