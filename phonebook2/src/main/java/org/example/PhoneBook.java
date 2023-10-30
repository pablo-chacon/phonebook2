package org.example;


import java.util.ArrayList;
import java.util.List;


public class PhoneBook {
    private List<Profile> profiles;


    public PhoneBook() {
        profiles = new ArrayList<>();
    }


     //@param profile The profile to be added.

    public void createProfile(Profile profile) {
        profiles.add(profile);
    }


     // Search @param lastName search.
     // @return Returns match.
        public List<Profile> searchByLastName(String lastName) {
        List<Profile> matchingProfiles = new ArrayList<>();
        for (Profile profile : profiles) {
            if (profile.getLastName().equalsIgnoreCase(lastName)) {
                matchingProfiles.add(profile);
            }
        }
        return matchingProfiles;
    }

    /**
     * Searches for profiles in the phone book based on the address.
     *
     * @param streetName The street name to search for.
     * @return Returns the profiles that have the same street name in their address.
     */
    public List<Profile> searchByAddress(String streetName) {
        List<Profile> matchingProfiles = new ArrayList<>();
        for (Profile profile : profiles) {
            if (profile.getAddress().getStreetName().equalsIgnoreCase(streetName)) {
                matchingProfiles.add(profile);
            }
        }
        return matchingProfiles;
    }

    /**
     * Searches for profiles in the phone book based on the first name.
     *
     * @param firstName The first name to search for.
     * @return Returns the profiles that match the first name.
     */
    public List<Profile> searchByFirstName(String firstName) {
        List<Profile> matchingProfiles = new ArrayList<>();
        for (Profile profile : profiles) {
            if (profile.getFirstName().equalsIgnoreCase(firstName)) {
                matchingProfiles.add(profile);
            }
        }
        return matchingProfiles;
    }

    /**
     * Searches for profiles in the phone book based on the contact information.
     *
     * @param searchTerm The search term to match against any contact information.
     * @return Returns the profiles that have any contact information that matches the search term.
     */
    public List<Profile> freeSearch(String searchTerm) {
        List<Profile> matchingProfiles = new ArrayList<>();
        for (Profile profile : profiles) {
            if (profile.getFirstName().equalsIgnoreCase(searchTerm) ||
                    profile.getLastName().equalsIgnoreCase(searchTerm) ||
                    profile.getAddress().getStreetName().equalsIgnoreCase(searchTerm) ||
                    profile.getAddress().getCity().equalsIgnoreCase(searchTerm) ||
                    profile.getAddress().getPostcode().equalsIgnoreCase(searchTerm) ||
                    profile.getPhoneNumbers().contains(searchTerm)) {
                matchingProfiles.add(profile);
            }
        }
        return matchingProfiles;
    }

    /**
     * Updates the contact information of a profile.
     *
     * @param profile The profile to be updated.
     * @param newContactInfo The new contact information.
     */
    public void updateProfile(Profile profile, ContactInfo newContactInfo) {
        profile.setContactInfo(newContactInfo);
    }

    /**
     * Deletes a profile from the phone book.
     *
     * @param profile The profile to be deleted.
     * @param isAdmin Specifies whether the user is an administrator or not.
     *                Only administrators can delete profiles.
     */
    public void deleteProfile(Profile profile, boolean isAdmin) {
        if (isAdmin) {
            profiles.remove(profile);
        } else {
            System.out.println("You do not have permission to delete profiles.");
        }
    }
}

/**
 * This class represents a profile of an individual in the phone book.
 */
class Profile {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private List<String> phoneNumbers;
    private ContactInfo contactInfo;

    /**
     * Constructor to initialize the profile.
     *
     * @param firstName The first name of the individual.
     * @param lastName The last name of the individual.
     * @param age The age of the individual.
     * @param address The address of the individual.
     * @param phoneNumbers The phone numbers of the individual.
     * @param contactInfo The contact information of the individual.
     */
    public Profile(String firstName, String lastName, int age, Address address, List<String> phoneNumbers, ContactInfo contactInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.contactInfo = contactInfo;
    }

    /**
     * Getter for the first name.
     *
     * @return Returns the first name of the individual.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for the last name.
     *
     * @return Returns the last name of the individual.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for the age.
     *
     * @return Returns the age of the individual.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for the address.
     *
     * @return Returns the address of the individual.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Getter for the phone numbers.
     *
     * @return Returns the phone numbers of the individual.
     */
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Getter for the contact information.
     *
     * @return Returns the contact information of the individual.
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Setter for the contact information.
     *
     * @param contactInfo The new contact information.
     */
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}

/**
 * This class represents the address of an individual in the phone book.
 */
class Address {
    private String city;
    private String postcode;
    private String streetName;
    private int gateNumber;

    /**
     * Constructor to initialize the address.
     *
     * @param city The city of the address.
     * @param postcode The postcode of the address.
     * @param streetName The street name of the address.
     * @param gateNumber The gate number of the address.
     */
    public Address(String city, String postcode, String streetName, int gateNumber) {
        this.city = city;
        this.postcode = postcode;
        this.streetName = streetName;
        this.gateNumber = gateNumber;
    }

    /**
     * Getter for the city.
     *
     * @return Returns the city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter for the postcode.
     *
     * @return Returns the postcode of the address.
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Getter for the street name.
     *
     * @return Returns the street name of the address.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Getter for the gate number.
     *
     * @return Returns the gate number of the address.
     */
    public int getGateNumber() {
        return gateNumber;
    }
}

/**
 * This class represents the contact information of an individual in the phone book.
 */
class ContactInfo {
    private String email;
    private String phoneNumber;

    /**
     * Constructor to initialize the contact information.
     *
     * @param email The email of the individual.
     * @param phoneNumber The phone number of the individual.
     */
    public ContactInfo(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for the email.
     *
     * @return Returns the email of the individual.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for the phone number.
     *
     * @return Returns the phone number of the individual.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}