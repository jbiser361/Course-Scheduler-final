
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author acv
 * @author James Biser
 * 
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private String currentSemester; 
    private String currentStudent;
    
    public MainFrame() {
        initComponents();
        rebuildSemesterComboBoxes();
        rebuildClassSelectComboBox();
        rebuildScheduleCourseComboBox();
        rebuildDropComboBox();
        rebuildStudentInCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentDropComboBox();
        rebuildDropStudentComboBox();

    }
   
    
    private void rebuildSemesterComboBoxes()
    {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        if (semesters.size() > 0)
        {
            currentSemesterLabel.setText(semesters.get(0));
            currentSemester = semesters.get(0);
        }
        else
        {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
        displayCourses();
    }
    
    private void rebuildStudentsComboBoxes(){
        ArrayList<String> students = StudentQueries.getStudentIDList();
        studentSelectBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
        if (!students.isEmpty()){
            
           currentStudent = students.get(0);
           currentStudentLabel.setText("Current Student Selected: " +students.get(0));
            currentStudentGlobalLabel.setText("Current Student Selected: " + currentStudent);

        } 
        else{
            currentStudentLabel.setText("Current Student Selected: None");
            currentStudentGlobalLabel.setText("Current Student Selected: " + currentStudent);

        }
        displayCourses();

    }
    
    private void rebuildStudentDropComboBox(){
        ArrayList<String> students = StudentQueries.getStudentIDList();
        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
    }
    
    private void rebuildClassSelectComboBox(){
        ArrayList<String> students = StudentQueries.getStudentIDList();
        studentSelectBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
        if (!students.isEmpty()){
            
           currentStudent = students.get(0);
           currentStudentLabel.setText("Current Student Selected: " +students.get(0));
            currentStudentGlobalLabel.setText("Current Student Selected: " + currentStudent);

        } 
        else{
            currentStudentLabel.setText("Current Student Selected: None");
            currentStudentGlobalLabel.setText("Current Student Selected: " + currentStudent);

        }
        displayCourses();

    }
    
    
    private void rebuildScheduleCourseComboBox(){
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        addCourseCombo.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
    }
    
    private void rebuildDropComboBox(){
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        dropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
    }
    // View Student in Class tab
    private  void rebuildStudentInCourseComboBox(){
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        classSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
        if (!courses.isEmpty()){
           viewAllStudentsInCourse(""+courses.get(0));
        } 
    }
    
    private void rebuildDropStudentComboBox(){
        ArrayList<ScheduleEntry> courses = ScheduleQueries.getScheduleByStudent(currentSemester, currentStudent);
        studentDropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
    }
    
    private void displayCourses(){
        
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        DefaultTableModel courseOfferingsTable2 = (DefaultTableModel)courseOfferingsTable.getModel(); 
        
        courseOfferingsTable2.setNumRows(0);
        Object[] rowData = new Object[3];
        
        for (CourseEntry course: courses){
            
            rowData[0] = course.getCourseCode();
            rowData[1] = course.getCourseDescription();
            rowData[2] = course.getSeats();
            courseOfferingsTable2.addRow(rowData);
            
        }
        
    }
    
    private void displayCurrentScheduleTable(){
        
                
        ArrayList<ScheduleEntry> courses = ScheduleQueries.getScheduleByStudent(currentSemester, currentStudent);
        DefaultTableModel courseOfferingsTable2 = (DefaultTableModel)CurrentScheduleTable.getModel(); 
        
        courseOfferingsTable2.setNumRows(0);
        Object[] rowData = new Object[3];
        
        for (ScheduleEntry course: courses){
            
            rowData[0] = course.getCourseCode();
            rowData[1] = course.getStatus();
            courseOfferingsTable2.addRow(rowData);
            
        }
    }
    // View Student in Class tab
    private void viewAllStudentsInCourse(String course){
        ArrayList<ScheduleEntry> courses = ScheduleQueries.getScheduleByCourse(currentSemester, course);
        DefaultTableModel courseOfferingsTable2 = (DefaultTableModel)viewStudentInClassTable.getModel(); 
        
        courseOfferingsTable2.setNumRows(0);
        Object[] rowData = new Object[3];
        
        for (ScheduleEntry course3: courses){
            
            rowData[0] = course3.getStudentID();
            rowData[1] = course3.getStatus();
            courseOfferingsTable2.addRow(rowData);
            
        }
        
       // viewStudentInClassTable
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        SuccessLabel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseDescriptionFeild = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        maxStudentsFeild = new javax.swing.JTextField();
        courseCodeFeild = new javax.swing.JTextField();
        successLabel = new javax.swing.JLabel();
        addCourseAction = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        dropCourseAction = new javax.swing.JButton();
        dropClassComboBox = new javax.swing.JComboBox<>();
        dropCourseSuccessLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        dropCourseAdminText = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        classSelectComboBox = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        viewStudentInClassTable = new javax.swing.JTable();
        changeSelectedClassAction = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        addStudentAction = new javax.swing.JButton();
        studentFirstName = new javax.swing.JTextField();
        studentLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addedSuccessLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        studentIDBox = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        dropStudentComboBox = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        dropStudentTextArea = new javax.swing.JTextArea();
        dropStudentAction = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CurrentScheduleTable = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        enrollAction = new javax.swing.JButton();
        addCourseCombo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        EnrollStatusLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        studentDropAction = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        studentDropCourseComboBox = new javax.swing.JComboBox<>();
        studentDropCourseSucessLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseOfferingsTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        studentSelectBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        changeStudentAction = new javax.swing.JButton();
        currentStudentLabel = new javax.swing.JLabel();
        currentStudentGlobalLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Scheduler");

        jLabel8.setText("Please Enter Course Information");

        jLabel11.setText("Course Code:");

        jLabel12.setText("Maximum Students:");

        courseDescriptionFeild.setColumns(20);
        courseDescriptionFeild.setRows(5);
        jScrollPane1.setViewportView(courseDescriptionFeild);

        jLabel13.setText("Course Description:");

        maxStudentsFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxStudentsFeildActionPerformed(evt);
            }
        });

        addCourseAction.setText("Add Course");
        addCourseAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SuccessLabelLayout = new javax.swing.GroupLayout(SuccessLabel);
        SuccessLabel.setLayout(SuccessLabelLayout);
        SuccessLabelLayout.setHorizontalGroup(
            SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuccessLabelLayout.createSequentialGroup()
                .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuccessLabelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(successLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SuccessLabelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseCodeFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maxStudentsFeild)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SuccessLabelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(addCourseAction)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        SuccessLabelLayout.setVerticalGroup(
            SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuccessLabelLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuccessLabelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SuccessLabelLayout.createSequentialGroup()
                        .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuccessLabelLayout.createSequentialGroup()
                                .addGroup(SuccessLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(maxStudentsFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseCodeFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addComponent(addCourseAction)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(successLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Course", SuccessLabel);

        dropCourseAction.setText("Drop Course");
        dropCourseAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropCourseActionActionPerformed(evt);
            }
        });

        dropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropCourseAdminText.setColumns(20);
        dropCourseAdminText.setRows(5);
        jScrollPane5.setViewportView(dropCourseAdminText);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dropCourseAction, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(dropClassComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(dropCourseSuccessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(dropClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(dropCourseAction)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(dropCourseSuccessLabel)
                .addGap(27, 27, 27))
        );

        jTabbedPane2.addTab("Drop Course", jPanel12);

        jLabel14.setText("View Students enolled and Waitlisted for a Class");

        jLabel20.setText("Class:");

        classSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        viewStudentInClassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Student ID", "Status"
            }
        ));
        jScrollPane4.setViewportView(viewStudentInClassTable);

        changeSelectedClassAction.setText("Change Class");
        changeSelectedClassAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSelectedClassActionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classSelectComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeSelectedClassAction, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(changeSelectedClassAction))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("View Students in Class", jPanel10);

        addSemesterTextfield.setColumns(20);

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        jLabel9.setText("Semester Name:");

        jLabel10.setText("Please Enter The Semester Name You'd Like to Add");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(103, 103, 103))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(527, 527, 527)
                        .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addSemesterTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(addSemesterSubmitButton))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addSemesterSubmitButton)
                .addGap(10, 10, 10)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Semester", jPanel3);

        addStudentAction.setText("Add Student");
        addStudentAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionActionPerformed(evt);
            }
        });

        studentFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentFirstNameActionPerformed(evt);
            }
        });

        studentLastName.setToolTipText("");
        studentLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentLastNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Please Enter The first and Last Name of the Student");

        jLabel5.setText("First Name: ");

        jLabel7.setText("Last Name:");

        jLabel6.setText("StudentID");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(494, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(131, 131, 131)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(addStudentAction, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentIDBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addedSuccessLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(studentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(studentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(studentIDBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(addStudentAction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addedSuccessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        jTabbedPane2.addTab("Add Student", jPanel5);

        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel22.setText("Select a Student to Drop, please note dropping a student will reset the selected student.");

        dropStudentTextArea.setColumns(20);
        dropStudentTextArea.setRows(5);
        jScrollPane6.setViewportView(dropStudentTextArea);

        dropStudentAction.setText("Drop Student");
        dropStudentAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentActionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dropStudentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dropStudentAction, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addComponent(jScrollPane6)
                .addGap(87, 87, 87))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(486, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(dropStudentAction))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Student", jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admin", jPanel1);

        jLabel15.setText("Your Current Schedule");

        CurrentScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Name", "Status"
            }
        ));
        jScrollPane3.setViewportView(CurrentScheduleTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jTabbedPane3.addTab("Current Schedule", jPanel6);

        jLabel17.setText("Select The Course You Want to Enroll in. ");

        enrollAction.setText("Enroll");
        enrollAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollActionActionPerformed(evt);
            }
        });

        addCourseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setText("Selected Course");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(enrollAction, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addComponent(addCourseCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(EnrollStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(enrollAction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnrollStatusLabel)
                .addGap(33, 33, 33))
        );

        jTabbedPane3.addTab("Schedule Courses", jPanel9);

        studentDropAction.setText("Drop Course");
        studentDropAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropActionActionPerformed(evt);
            }
        });

        jLabel21.setText("Select The Course You Want to Drop");

        studentDropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentDropCourseSucessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(studentDropAction, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(studentDropCourseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(studentDropCourseComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(studentDropAction)
                .addGap(45, 45, 45)
                .addComponent(studentDropCourseSucessLabel)
                .addGap(31, 31, 31))
        );

        jTabbedPane3.addTab("Drop Course", jPanel4);

        jLabel16.setText("Course Offerings");

        courseOfferingsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Code", "Description", "Seats"
            }
        ));
        jScrollPane2.setViewportView(courseOfferingsTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1197, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course Offerings", jPanel7);

        studentSelectBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Select Student");

        changeStudentAction.setText("Change Student");
        changeStudentAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeStudentActionActionPerformed(evt);
            }
        });

        currentStudentLabel.setText("Student Selected: ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(studentSelectBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeStudentAction, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(currentStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(693, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeStudentAction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(currentStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane3.addTab("Settings", jPanel8);

        currentStudentGlobalLabel.setText("Current Student: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentStudentGlobalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentStudentGlobalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student", jPanel2);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        currentSemesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentSemesterComboBoxActionPerformed(evt);
            }
        });

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(changeSemesterButton)
                                .addGap(80, 80, 80)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = addSemesterTextfield.getText();
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildSemesterComboBoxes();
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    private void currentSemesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentSemesterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentSemesterComboBoxActionPerformed

    private void studentLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentLastNameActionPerformed

    private void studentFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentFirstNameActionPerformed

    private void maxStudentsFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxStudentsFeildActionPerformed

    }//GEN-LAST:event_maxStudentsFeildActionPerformed

    private void addCourseActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionActionPerformed
        // TODO add your handling code here:
        int maxStudents = Integer.parseInt(maxStudentsFeild.getText());
        CourseQueries.addCourse(currentSemester, courseCodeFeild.getText(), courseDescriptionFeild.getText(), maxStudents);
        successLabel.setText("Added "+ courseCodeFeild.getText() + " Sucessfully");
        displayCourses();
        rebuildScheduleCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentInCourseComboBox();
        rebuildDropComboBox();
        rebuildDropStudentComboBox();


    }//GEN-LAST:event_addCourseActionActionPerformed

    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        currentSemester = String.valueOf(currentSemesterComboBox.getSelectedItem());
        currentSemesterLabel.setText(currentSemester);
        rebuildScheduleCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentInCourseComboBox();
        rebuildScheduleCourseComboBox();
        rebuildDropComboBox();
        rebuildDropStudentComboBox();


    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void addStudentActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionActionPerformed
        StudentQueries.addStudent(studentFirstName.getText(), studentLastName.getText(), studentIDBox.getText());
        addedSuccessLabel.setText("Sucessfully Added " + studentFirstName.getText() +" "+ studentLastName.getText());
        rebuildStudentsComboBoxes();
        rebuildDropStudentComboBox();
        rebuildScheduleCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentDropComboBox();
    }//GEN-LAST:event_addStudentActionActionPerformed

    private void changeStudentActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeStudentActionActionPerformed
        // TODO add your handling code here:
        currentStudent = String.valueOf(studentSelectBox.getSelectedItem());
        currentStudentLabel.setText("Current Student Selected: " + currentStudent);
        currentStudentGlobalLabel.setText("Current Student Selected: " + currentStudent);
        rebuildScheduleCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentDropComboBox();
        rebuildDropStudentComboBox();

    }//GEN-LAST:event_changeStudentActionActionPerformed

    private void enrollActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollActionActionPerformed
        // TODO add your handling code here:
        
        String semester = currentSemesterLabel.getText();
        String courseCode = addCourseCombo.getSelectedItem().toString();
        String studentID = currentStudent;
        String status = "W";
        int totalSeats = CourseQueries.getCourseSeats(semester, courseCode);
        int studentSeats = ScheduleQueries.getScheduledStudentCount(semester, courseCode);
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        if (totalSeats > studentSeats) {
            status = "S";
            EnrollStatusLabel.setText("Student " + currentStudent + " has been scheduled for course " + courseCode + ".");
        }else{
            EnrollStatusLabel.setText("Student " + currentStudent + " has been waitlisted for course " + courseCode + ".");
        }
        Timestamp timeStamp = timestamp2;
                
        ScheduleEntry schedule = new ScheduleEntry(semester, courseCode, studentID, status, timeStamp);
        ScheduleQueries.addScheduleEntry(schedule);
        
        rebuildScheduleCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentInCourseComboBox();
        rebuildScheduleCourseComboBox();
        rebuildDropComboBox();
        rebuildStudentDropComboBox();
        rebuildDropStudentComboBox();


    }//GEN-LAST:event_enrollActionActionPerformed
//View Students in Class
    private void changeSelectedClassActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSelectedClassActionActionPerformed
       String currentClass = String.valueOf(classSelectComboBox.getSelectedItem());
       viewAllStudentsInCourse(currentClass);
    }//GEN-LAST:event_changeSelectedClassActionActionPerformed
//View Students in Class
    private void dropCourseActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropCourseActionActionPerformed
        // TODO add your handling code here:
        String classToDrop = String.valueOf(dropClassComboBox.getSelectedItem());
        ArrayList<ScheduleEntry> courses = ScheduleQueries.getScheduleByCourse(currentSemester, classToDrop);
        dropCourseAdminText.setText("");
        for (ScheduleEntry course3: courses){
            dropCourseAdminText.append("" + course3.getStudentID()+" has been dropped from "+classToDrop+"\n");
            
        }
        ScheduleQueries.removeCourse(currentSemester, classToDrop);
        CourseQueries.dropCourse(currentSemester, classToDrop);
        dropCourseSuccessLabel.setText("Sucessfully Dropped: " + classToDrop);
        rebuildScheduleCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentInCourseComboBox();
        rebuildScheduleCourseComboBox();
        rebuildDropComboBox();
        rebuildStudentDropComboBox();
        rebuildDropStudentComboBox();
        rebuildScheduleCourseComboBox() ;

    }//GEN-LAST:event_dropCourseActionActionPerformed

    private void studentDropActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropActionActionPerformed

        String classToDrop = String.valueOf(studentDropCourseComboBox.getSelectedItem());
        ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlisted(currentSemester, classToDrop);
        ScheduleQueries.dropStudentFromCourse(currentSemester, classToDrop, currentStudent);

        if (!waitlisted.isEmpty()){

            for (ScheduleEntry w:waitlisted){
                System.out.print(w.getStudentID());

                if (w.getStudentID().equals(currentStudent)){
                        rebuildScheduleCourseComboBox();
                        displayCurrentScheduleTable();
                        rebuildStudentInCourseComboBox();
                        rebuildScheduleCourseComboBox();
                        rebuildDropComboBox();
                        rebuildStudentDropComboBox();
                        studentDropCourseSucessLabel.setText("Sucesfully dropped "+classToDrop);

                        return;
                }
            }
            ScheduleQueries.updateStudentFromWaitlist(currentSemester, classToDrop, waitlisted.get(0).getStudentID());
            studentDropCourseSucessLabel.setText("Sucesfully dropped "+classToDrop+"   Enrolled "+ waitlisted.get(0).getStudentID());

        }
        else{
            studentDropCourseSucessLabel.setText("Sucesfully dropped "+classToDrop);
        }        
                rebuildScheduleCourseComboBox();
                displayCurrentScheduleTable();
                rebuildStudentInCourseComboBox();
                rebuildScheduleCourseComboBox();
                rebuildDropComboBox();
                rebuildStudentDropComboBox();
                rebuildDropStudentComboBox();
    }//GEN-LAST:event_studentDropActionActionPerformed

    private void dropStudentActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentActionActionPerformed
        // TODO add your handling code here:
        //text area dropStudentTextArea
        String studentToDrop = String.valueOf(dropStudentComboBox.getSelectedItem());
        ArrayList<ScheduleEntry> courses = ScheduleQueries.getWholeScheduleByStudent(studentToDrop);

        String dropStatement = "";
        String semester;
        if (!courses.isEmpty()){
            
            semester = courses.get(0).getSemester();
            dropStatement += semester+"\n";
            for (ScheduleEntry w:courses){
                if(!w.getSemester().equals(semester)){
                   semester = w.getSemester();
                   dropStatement +="\n"+semester+"\n";
                }
                ScheduleQueries.dropStudentFromCourse(w.getSemester(), w.getCourseCode(), studentToDrop);
                
                ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlisted(w.getSemester(), w.getCourseCode());
                String sID = dropClass(waitlisted, studentToDrop,w.getCourseCode(),w.getSemester());
                if (!sID.equals(studentToDrop)){
                    dropStatement += StudentQueries.getStudentName(sID)+", "+sID+" has been scheduled to "+w.getCourseCode()+"\n";
                }
            }
        }    
        StudentQueries.dropStudent(studentToDrop);
        
        dropStudentTextArea.setText(dropStatement +"\n" + studentToDrop +" Has been removed from all comboboxes, scheduled courses, and waitlisted courses");
        rebuildStudentsComboBoxes();
        rebuildStudentDropComboBox();
        rebuildScheduleCourseComboBox();
        displayCurrentScheduleTable();
        rebuildStudentInCourseComboBox();
        rebuildScheduleCourseComboBox();
        rebuildDropComboBox();
        rebuildStudentDropComboBox();
        rebuildDropStudentComboBox();

    }//GEN-LAST:event_dropStudentActionActionPerformed

    
    public String dropClass(ArrayList<ScheduleEntry> waitlisted, String studentToDrop, String courseCode, String semester){
        if (!waitlisted.isEmpty()){
                    for (ScheduleEntry z:waitlisted){
                        if (z.getStudentID().equals(studentToDrop)){
                                rebuildStudentsComboBoxes();
                                rebuildStudentDropComboBox();
                                rebuildScheduleCourseComboBox();
                                displayCurrentScheduleTable();
                                rebuildStudentInCourseComboBox();
                                rebuildScheduleCourseComboBox();
                                rebuildDropComboBox();
                                rebuildStudentDropComboBox();
                                rebuildDropStudentComboBox();
                               // studentDropCourseSucessLabel.setText("Sucesfully dropped "+classToDrop);
                                return ""+studentToDrop;
                        }
                   
                    }
                    ScheduleQueries.updateStudentFromWaitlist(semester, courseCode, waitlisted.get(0).getStudentID());
                    return ""+waitlisted.get(0).getStudentID();
        }
        return""+studentToDrop;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CurrentScheduleTable;
    private javax.swing.JLabel EnrollStatusLabel;
    private javax.swing.JPanel SuccessLabel;
    private javax.swing.JButton addCourseAction;
    private javax.swing.JComboBox<String> addCourseCombo;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JButton addStudentAction;
    private javax.swing.JLabel addedSuccessLabel;
    private javax.swing.JButton changeSelectedClassAction;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JButton changeStudentAction;
    private javax.swing.JComboBox<String> classSelectComboBox;
    private javax.swing.JTextField courseCodeFeild;
    private javax.swing.JTextArea courseDescriptionFeild;
    private javax.swing.JTable courseOfferingsTable;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JLabel currentStudentGlobalLabel;
    private javax.swing.JLabel currentStudentLabel;
    private javax.swing.JComboBox<String> dropClassComboBox;
    private javax.swing.JButton dropCourseAction;
    private javax.swing.JTextArea dropCourseAdminText;
    private javax.swing.JLabel dropCourseSuccessLabel;
    private javax.swing.JButton dropStudentAction;
    private javax.swing.JComboBox<String> dropStudentComboBox;
    private javax.swing.JTextArea dropStudentTextArea;
    private javax.swing.JButton enrollAction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField maxStudentsFeild;
    private javax.swing.JButton studentDropAction;
    private javax.swing.JComboBox<String> studentDropCourseComboBox;
    private javax.swing.JLabel studentDropCourseSucessLabel;
    private javax.swing.JTextField studentFirstName;
    private javax.swing.JTextField studentIDBox;
    private javax.swing.JTextField studentLastName;
    private javax.swing.JComboBox<String> studentSelectBox;
    private javax.swing.JLabel successLabel;
    private javax.swing.JTable viewStudentInClassTable;
    // End of variables declaration//GEN-END:variables
}
