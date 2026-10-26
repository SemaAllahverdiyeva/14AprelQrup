package az.developia.spring_project_14Aprel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import az.developia.spring_project_14Aprel.entity.Computer;
import az.developia.spring_project_14Aprel.repository.ComputerRepo;
import az.developia.spring_project_14Aprel.repository.UserRepository;
import az.developia.spring_project_14Aprel.responseDto.ComputerResponseDto;

@ExtendWith(MockitoExtension.class)
public class ComputerServiceTest {

    @Mock
    private ComputerRepo computerRepo;

    @InjectMocks
    private ComputerService computerService;

    @Mock
    private ModelMapper mapper;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        System.out.println("Runs before each test method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Runs after each test method");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Runs before all test methods");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Runs after all test methods");
    }

    @Test
    void getComputerInfo() {
        Computer computer = new Computer();
        computer.setId(1);

        when(computerRepo.findById(1))
                .thenReturn(Optional.of(computer));

        ComputerResponseDto response = computerService.getComputerById(1);

        assertNotNull(response);

        verify(computerRepo).findById(1);
    }

    @Test
    void deleteComputer() {

        computerService.deleteComputer(1);

        verify(computerRepo).deleteById(1);
    }
}
