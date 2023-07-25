package io.raol.helloWorld

import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val logger = Logger.getRootLogger

    val conf = new SparkConf()
      .setAppName(HelloWorld.getClass.getName)

    val spark = SparkSession.builder
      .config(conf)
      .getOrCreate()

    var df = spark.read
      .format("csv")
      .option("header", value = true)
      .option("inferSchema", value = true)
      .load("/data/books.csv")

    logger.info("Loaded dataset")

    logger.info(s"Record count ${df.count()}")
  }
}