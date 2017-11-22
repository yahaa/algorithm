import pymysql
import random
import datetime

conn = pymysql.connect(
    host='localhost',
    port=3306,
    user='root',
    passwd='Gmr1998',
    db='webservice',
    charset='utf8'
)
cur = conn.cursor()


def sn():
    num = cur.execute('select sn from inverter')
    sn_list = cur.fetchmany(num)
    # print(sn_list)
    return num, sn_list


def sn_sql(t, sn_num):
    insert_sql = """
          insert into inverter_data(id ,busvoltage, gfci, inverter_on_the_day_power, inverter_on_the_month_power, inverter_on_the_year_power,
          inverter_outputs_the_total_active_power, inverter_temperature, inverter_total_output_reactive_power, inverter_total_power_generation, 
          iotal_power_factor_of_inverter, l1phase_current, l1phasedccomponent, l1phase_frequency, l1phase_voltage, l1power,
          l1power_factor,l2dccomponent, l2phase_current, l2phase_frequency, l2phase_voltage, l2power, l2power_factor, l3phase_current,
          l3phasedccomponent, l3phase_frequency, l3phase_voltage, l3power,l3power_factor,number_of_inverter_errors, number_of_working_hours_of_the_inverter, pv1power, 
          pv1total_current,pv1voltage, pv1_iso, pv2total_current, pv2voltage, pv2_iso,pv3power, pv3total_current, pv3voltage, 
          pv3_iso, pv__iso, total_number_of_hours_of_inverter_operation, work_mode, inverter_sn, time)
          VALUES (%s, %s, %s, %s ,%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s,
          %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s,%s, %s, %s, %s, %s, %s,%s, %s, %s,
          %s, %s, %s, %s, %s)
          """  # 47
    for i in range(20000, 50000):
        cur.execute(insert_sql, (i,
                                 random.uniform(0, 100),
                                 random.randint(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.randint(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 random.uniform(0, 100),
                                 str(random.randint(0, 100)),
                                 sn_num,
                                 datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
                                 )
                    )  # 49
        conn.commit()


def csql():
    num, sn_list = sn()
    t = 0
    for sn_num in sn_list:
        sn_sql(t, sn_num[0])
        t += 1
    conn.close()

csql()
